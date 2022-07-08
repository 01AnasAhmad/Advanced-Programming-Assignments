package com.company;
import java.util.*;
// OPTION 1--->>ADD VACCINE...
class AddVaccine{

    private final String VaccineName;
    private final int doses;
    private final int gap;

    AddVaccine(String VaccineName, int doses, int gap){
        this.VaccineName = VaccineName;
        this.doses = doses;
        this.gap = gap;
    }

    //Constructor OverLoading...
    AddVaccine(String VaccineName,int doses){
        this.VaccineName = VaccineName;
        this.doses = doses;
        this.gap = 0;
    }

    //GETTERS

    String getVaccName(){return VaccineName;}

    int getDoses(){return doses;}

    int getGap(){return gap;}

    public String toString(){
        return "Vaccine Name:"+VaccineName+","+"Number of Doses:"+doses+","+"Gap Between Doses:"+gap;
    }
}

// OPTION 2--->>REGISTER HOSPITAL...
class RegisterHospital{

    //private ArrayList<CreateSlots> slots;
    private final String HospitalName;
    private final int pincode;
    private final long UniqueID;

    ArrayList<CreateSlots> arrayList=new ArrayList<>();

    //Constructor...Created!
    RegisterHospital(String HospitalName,int pincode,long UniqueID){
        this.HospitalName = HospitalName;
        this.pincode = pincode;
        this.UniqueID = UniqueID;
    }

    //GETTERS:

    long getUniqueID(){return UniqueID;}

    String getHospitalName(){
        return HospitalName;
    }

    int getPincode(){
        return pincode;
    }

    public String toString(){
        return "Hospital Name:"+HospitalName+","+"PinCode:"+pincode+","+"Unique ID :";
    }

}

// OPTION 4--->>ADD SLOT FOR VACCINATION...
class CreateSlots{

    private final long hospId;
    private final int Day;
    private int Quantity;
    private final int VaccChoice;


    CreateSlots(int Day,int Quantity,int VaccChoice,long hospId){

        this.Day = Day;
        this.Quantity = Quantity;
        this.VaccChoice = VaccChoice;
        this.hospId = hospId;

    }

    int getDay(){
        return Day;
    }

    int getQuantity(){
        return Quantity;
    }

    int getVaccChoice(){return VaccChoice;}

    //SETTERS:
    void setQuantity(int newQty){this.Quantity=newQty ;}

    public String toString(){
        return " for Day:"+Day+","+"Available Quantity:"+Quantity+" "+"Of Vaccine ";
    }
}
// OPTION 3--->>REGISTER CITIZEN...
class RegisterCitizen{

    private final String Name;
    private final int Age;
    private final long aadharID;
    private String Status ;
    private String VaccGiven;
    private int doseTaken;
    private int duedate;

    RegisterCitizen(String Name,int Age,long aadharID){
        this.Name = Name;
        this.Age = Age;
        this.aadharID = aadharID;
        this.Status = "REGISTERED";
        this.VaccGiven = "";
        this.doseTaken = 0;
        this.duedate = 0;
    }

    //GETTERS:

    String getName(){
        return Name;
    }

    String getStatus(){return Status;}

    int getDoseTaken(){ return doseTaken; }

    String getVaccGiven(){ return VaccGiven;}

    int getDuedate(){return duedate; }

    //SETTERS:
    void setVaccGiven(String Vaccname){VaccGiven = Vaccname;}

    void setDoseTaken(int newdose){doseTaken=newdose;}

    void setDuedate(int newdate){duedate = newdate; }

    void setStatus(String newState){Status = newState; }

    public String toString(){
        return "Citizen Name:"+Name+","+"Age:"+Age+","+"Unique ID:"+aadharID+"\n";
    }
}

public class Main {

    public static void MENU(){

        System.out.println("---------------------------------------------");
        System.out.println("           1 . Add Vaccine ");
        System.out.println("           2 . Register Hospital");
        System.out.println("           3 . Register Citizen");
        System.out.println("           4 . Add Slot For Vaccination ");
        System.out.println("           5 . Book Slots For Vaccination");
        System.out.println("           6 . List All Slots For A Hospital");
        System.out.println("           7 . Check Vaccination Status");
        System.out.println("           8 . Exit");
        System.out.println("---------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MENU();
        System.out.println("CoWin Portal Initialized . . .");

        //We in all need 4 Hash Maps to work with ...
        // 1 Array list object in order to complete the composition task between
        // Hospital And Slots Class

        int PosCount = 0;// For Option 1 ---> Vaccine Name Indexing...
        long HospitalUniqueId = 111000;

        HashMap<Integer,AddVaccine> VaccineAddedMap = new HashMap<>();//For Option 1
        HashMap<Long,RegisterHospital> RegisterHospitalMap = new HashMap<>();//For Option 2
        HashMap<Long,RegisterCitizen> RgstrCtznMap = new HashMap<>();//For Option 3

        HashMap<Long,ArrayList<CreateSlots>> CreatedSlotss = new HashMap<>();//For Option 4
        ArrayList<RegisterHospital> hospARRobj = new ArrayList<>(); //Arraylist of hospital class object

        while(true){
            int option = sc.nextInt();
            if (option == 1) {
                System.out.print("Vaccine Name:" + "");
                String Vaccname = sc.next();
                System.out.print("Number Of Doses:" + "");
                int doses = sc.nextInt();
                if(doses==1){
                    AddVaccine vaccine = new AddVaccine(Vaccname,doses);
                    System.out.println(vaccine); //toString
                    VaccineAddedMap.put(PosCount,vaccine);
                    PosCount += 1;
                }
                else if(doses>1) {
                    System.out.print("Gap between Doses:" + "");
                    int gaps = sc.nextInt();
                    AddVaccine vaccine = new AddVaccine(Vaccname, doses, gaps);
                    System.out.println(vaccine);
                    VaccineAddedMap.put(PosCount,vaccine);
                    PosCount += 1;
                }
                MENU();
            }
            else if(option==2){
                System.out.print("Hospital Name:"+"");
                String HospName = sc.next();
                System.out.print("PinCode:"+"");
                int pinCode = sc.nextInt();
                HospitalUniqueId+=1;
                RegisterHospital RegHosp = new RegisterHospital(HospName,pinCode,HospitalUniqueId);
                ArrayList<CreateSlots> slotList = new ArrayList<>();
                CreatedSlotss.put(HospitalUniqueId,slotList);
                RegisterHospitalMap.put(HospitalUniqueId,RegHosp);
                System.out.println(RegHosp); //toString
                System.out.println(HospitalUniqueId);
                hospARRobj.add(RegHosp);

                MENU();
            }
            else if(option==3){
                System.out.print("Citizen Name:"+"");
                String CitizenName = sc.next();
                System.out.print("Age:"+"");
                int Age = sc.nextInt();
                System.out.print("Unique ID:");
                long uniqueID = sc.nextLong();
                RegisterCitizen Citizen = new RegisterCitizen(CitizenName,Age,uniqueID);
                System.out.print(Citizen);
                if(Age>18)
                    RgstrCtznMap.put(uniqueID,Citizen);
                else System.out.print("Only Above 18 Allowed\n");

                MENU();
            }
            else if(option==4) {
                System.out.print("Enter Hospital ID:");
                long id = sc.nextLong();
                System.out.print("Enter number of Slots to be Added:");
                int noofslots = sc.nextInt();
                if (noofslots >= 1) {
                    while (noofslots-- > 0) {
                        System.out.print("Enter Day Number:");
                        int day = sc.nextInt();
                        System.out.print("Enter Quantity:");
                        int qty = sc.nextInt();
                        System.out.println("Select Vaccine");
                        int displayVaccine = VaccineAddedMap.size();
                        for (int i = 0; i < displayVaccine; i++) {
                            System.out.println(i + " . " + VaccineAddedMap.get(i).getVaccName());
                        }
                        int vaccChoice = sc.nextInt();
                        if (vaccChoice < displayVaccine) {
                            CreateSlots slotsCreateOBJ = new CreateSlots(day,qty,vaccChoice,id);
                            System.out.print("Slot Added by Hospital "+id+"");
                            //for option 5 --- 2
                            RegisterHospital hospital = RegisterHospitalMap.get(id);
                            hospital.arrayList.add(slotsCreateOBJ);
                            System.out.print(slotsCreateOBJ); //Calling to toString method!
                            System.out.println(VaccineAddedMap.get(vaccChoice).getVaccName());

                            CreatedSlotss.get(id).add(slotsCreateOBJ);
                        }
                    }
                }
                MENU();
            }
            else if(option==5) {
                System.out.print("Enter Patient Unique ID:");
                long uniqId = sc.nextLong();
                System.out.println("1.Search by Area");
                System.out.println("2.Search by Vaccine");
                System.out.println("3.Exit");
                System.out.print("Enter Option:");
                int opt = sc.nextInt();
                int flag = 0;
                if (opt == 1) {
                    System.out.print("Enter PinCode:");
                    int pinCode = sc.nextInt();

                    for (Map.Entry<Long,RegisterHospital> mapElement : RegisterHospitalMap.entrySet()) {
                        RegisterHospital val =  mapElement.getValue();
                        if (val.getPincode() == pinCode) {
                            flag = 1;   //YAY ! Value is present !
                            long Hospitalid = mapElement.getKey();//Refers To Hospital ID . . .
                            System.out.print(Hospitalid + " " + val.getHospitalName() + "\n");
                            //Now Same Functionality as of Option 6!
                            ArrayList<CreateSlots> display = CreatedSlotss.get(Hospitalid);
                            System.out.print("Enter Hospital id:");
                            int getMax = 0;
                            long enterKey = sc.nextLong();
                            if (enterKey == Hospitalid) {
                                for (int i = 0; i < display.size(); i++) {
                                    CreateSlots y = display.get(i);
                                    System.out.print(i + " -> Day " + y.getDay() + " ");
                                    System.out.print("Vaccine " + VaccineAddedMap.get(y.getVaccChoice()).getVaccName());
                                    System.out.println(" Available Qty:" + y.getQuantity() + "");
                                    getMax = Math.max(y.getDay(),getMax);

                                }
                                System.out.print("Choose Slot:");
                                int chosen = sc.nextInt();
                                if (chosen < display.size()) {//chosed.Day,VaccineAddedMap.get(chosed.VaccChoice).getVaccName(),chosed.Quantity
                                    CreateSlots chosed = display.get(chosen);//chosed is not a word ...Bad english = Sed lyf

                                    String vacname = VaccineAddedMap.get(chosed.getVaccChoice()).getVaccName();
                                    AddVaccine objVaccine = VaccineAddedMap.get(chosed.getVaccChoice());
                                    int ReqDoses = objVaccine.getDoses();
                                    RegisterCitizen citizenVac = RgstrCtznMap.get(uniqId);

                                    if(citizenVac.getDuedate()>getMax) System.out.println("No Slots Available");

                                    else if (citizenVac.getDoseTaken() < ReqDoses) {
                                        citizenVac.setVaccGiven(vacname);
                                        chosed.setQuantity(chosed.getQuantity() - 1);

                                        for (Map.Entry<Integer,AddVaccine> mapEle : VaccineAddedMap.entrySet()) {
                                            AddVaccine ele =  mapEle.getValue();
                                            if (ele.getDoses() == citizenVac.getDoseTaken() && ele.getVaccName().equals(vacname)) {
                                                citizenVac.setDuedate(0);
                                                citizenVac.setDoseTaken(ele.getDoses());
                                                citizenVac.setStatus("FULLY VACCINATED");
                                                System.out.println(citizenVac.getName() + " Vaccinated with " + ele.getVaccName());
                                            }
                                            else if (ele.getDoses() > 1 && ele.getVaccName().equals(vacname)) {
                                                int add = ele.getGap();
                                                citizenVac.setDoseTaken(citizenVac.getDoseTaken() + 1);
                                                citizenVac.setDuedate(add + chosed.getDay());
                                                citizenVac.setStatus("PARTIALLY VACCINATED");
                                                System.out.println(citizenVac.getName() + " Vaccinated with " + ele.getVaccName());
                                            }
                                        }
                                    }
                                    //System.out.println("+"+chosed.getDay()+"+");SOCHA THA MGR WAQT KAHA HAI!
                                    if(chosed.getDay()>=citizenVac.getDuedate() && citizenVac.getDoseTaken() < ReqDoses){
                                        String vacgiven = citizenVac.getVaccGiven();
                                        if(vacgiven.equals("")) break;
                                        if(chosed.getQuantity()>0){
                                            if(vacgiven.equals(vacname)){
                                                if(citizenVac.getDoseTaken() - ReqDoses==1){
                                                    chosed.setQuantity(chosed.getQuantity() - 1);
                                                    citizenVac.setDuedate(0);
                                                    citizenVac.setDoseTaken(1+citizenVac.getDoseTaken());
                                                    citizenVac.setStatus("FULLY VACCINATED");
                                                    System.out.println(citizenVac.getName() + " Vaccinated with " + vacgiven);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else System.out.println("Wrong ID Entered !");
                        }
                    }
                    if (flag == 0) System.out.println("Pincode Not Present !");
                }
                else if (opt == 2) {
                    //uniqID//Registered patient TAKEN ABOVE INPUT!
                    System.out.print("Enter Vaccine Name:");
                    String Vacc = sc.next();//Vaccine name...
                    ArrayList<Long> HospID = new ArrayList<>();
                    boolean add = false;
                    for (Map.Entry<Long, RegisterHospital> entry : RegisterHospitalMap.entrySet()) {
                        RegisterHospital give = entry.getValue();
                        long hospID = give.getUniqueID();
                        ArrayList<CreateSlots> h = CreatedSlotss.get(hospID);
                        for (CreateSlots x : h) {
                            String VACC = VaccineAddedMap.get(x.getVaccChoice()).getVaccName();
                            if (VACC.equals(Vacc)) {
                                System.out.println(hospID + " " + hospARRobj.get((int) (hospID - 111001)).getHospitalName());
                                HospID.add(hospID);
                                add = true;
                            }
                        }
                    }
                    if (!add) {
                        System.out.println("No slots Availabe");
                        return;
                    }
                    System.out.print("Enter Hospital id:");
                    long codeHospital = sc.nextLong();//Hospital id
                    boolean jhanda = false;
                    RegisterCitizen citizen = RgstrCtznMap.get(uniqId);///CITIZEN OBJECT
                    for (long e : HospID) {
                        if (e == codeHospital) {
                            RegisterHospital hospital = hospARRobj.get((int) codeHospital - 111001);//HOSPITAL OBJECT

                            for (int i = 0; i < hospital.arrayList.size(); i++) {
                                CreateSlots slots = hospital.arrayList.get(i);
                                String vac = VaccineAddedMap.get(slots.getVaccChoice()).getVaccName();
                                AddVaccine objVaccine = VaccineAddedMap.get(slots.getVaccChoice());
                                if (vac.equals(Vacc)) {
                                    if (slots.getQuantity() > 0) {
                                        if (citizen.getDuedate() <= slots.getDay()) {
                                            if ((citizen.getDoseTaken() < objVaccine.getDoses())) {
                                                System.out.println(i+"-> Day:"+ slots.getDay()+"Available Qty:"+ slots.getQuantity()+"Vaccine:"+vac);
                                                jhanda = true;
                                            }
                                        }
                                    }
                                }
                            }
                            if(!jhanda){
                                System.out.println("No slots Availabe");
                                break;
                            }
                            System.out.print("Choose Slot:");
                            int chosen = sc.nextInt();
                            if (chosen < hospital.arrayList.size()) {
                                CreateSlots chosed = hospital.arrayList.get(chosen);//chosed is not a word ...Bad english = Sed lyf
                                if(chosed.getQuantity()<=0){
                                    System.out.println("No Slots Availabe");
                                    break;
                                }
                                chosed.setQuantity(chosed.getQuantity() - 1);
                                String vacname = VaccineAddedMap.get(chosed.getVaccChoice()).getVaccName();
                                AddVaccine objVaccine = VaccineAddedMap.get(chosed.getVaccChoice());
                                int ReqDoses = objVaccine.getDoses();
                                RegisterCitizen citizenVac = RgstrCtznMap.get(uniqId);

                                if (citizenVac.getDoseTaken() < ReqDoses) {

                                    for (Map.Entry<Integer,AddVaccine> mapEle : VaccineAddedMap.entrySet()) {
                                        AddVaccine ele =  mapEle.getValue();
                                        if (ele.getDoses() == objVaccine.getDoses() && ele.getVaccName().equals(vacname)) {
                                            citizenVac.setDuedate(0);
                                            citizenVac.setDoseTaken(ele.getDoses());
                                            citizenVac.setStatus("FULLY VACCINATED");
                                            System.out.println(citizenVac.getName() + " Vaccinated with " + ele.getVaccName());
                                        }
                                        else if (ele.getDoses() > 1 && ele.getVaccName().equals(vacname)) {
                                            int adder = ele.getGap();
                                            citizenVac.setDoseTaken(citizenVac.getDoseTaken() + 1);
                                            citizenVac.setDuedate(adder + chosed.getDay());
                                            citizenVac.setStatus("PARTIALLY VACCINATED");
                                            System.out.println(citizenVac.getName() + " Vaccinated with " + ele.getVaccName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                MENU();
            }
            else if(option==6){
                System.out.print("Enter Hospital Id:");
                long idHospital = sc.nextLong();
                ArrayList<CreateSlots> h = CreatedSlotss.get(idHospital);
                for (CreateSlots slots : h) {
                    System.out.print("Day " + slots.getDay() + " ");
                    System.out.print("Vaccine " + VaccineAddedMap.get(slots.getVaccChoice()).getVaccName());
                    System.out.println(" Available Qty:" + slots.getQuantity() + "");
                }
                MENU();
            }
            else if(option==7){
                System.out.print("Enter Patient ID:");
                long PatientId = sc.nextLong();
                RegisterCitizen citizenVac = RgstrCtznMap.get(PatientId);
                String status = citizenVac.getStatus();
                switch (status) {
                    case "REGISTERED" -> System.out.println("Citizen " + citizenVac.getStatus());
                    case "PARTIALLY VACCINATED" -> {
                        System.out.println(citizenVac.getStatus());
                        System.out.println("Vaccine Given:" + citizenVac.getVaccGiven());
                        System.out.println("Number of Doses given:" + citizenVac.getDoseTaken());
                        System.out.println("Next Dose Due Date:" + citizenVac.getDuedate());
                    }
                    case "FULLY VACCINATED" -> {
                        System.out.println(citizenVac.getStatus());
                        System.out.println("Vaccine Given:" + citizenVac.getVaccGiven());
                        System.out.println("Number of Doses given:" + citizenVac.getDoseTaken());
                    }
                }
                MENU();
            }
            else if (option == 8) {
                System.out.println("----------EXITING----------");
                break;
            }
        }
    }
}