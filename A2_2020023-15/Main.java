package com.company;

import java.util.*;

class Student{
    private String student;
    private int count;
    Student(String Name,int count){
        this.student = Name;
        this.count = count;
    }
    public String getStudent() {
        return student;
    }
}

class Instructor{
    private String name;
    private int count;

    Instructor(String Name,int count){
        this.name = Name;
        this.count = count;
    }
    public String getName() {return name;}
}

class Comment{
    private Instructor instructor;
    private Student student;
    private String Data;

    Comment(Instructor instructor, String data){
        this.instructor = instructor;
        this.Data = data;
    }
    Comment(Student student,String data){
        this.student = student;
        this.Data = data;
    }

    public String getData() {return Data;}
    public String getInstructor() {return instructor.getName();}
    public Student getStudent() {return student;}

}

interface Assessments{
    void viewAssessments();
    void Grading(int MarksScored,Instructor instructor);
    void ViewGrading();
}

class Assignment implements Assessments{
    private Instructor teacher;
    private Student student;
    private int MaxMarks;
    private int MarksObtained;
    private boolean ungraded;
    private boolean open;
    private String submitted;
    private boolean submit;
    private String instructor;
    private String Problem;

    Assignment(String problem, int MaxMarks, Student s){
        this.Problem = problem;
        this.MaxMarks = MaxMarks;
        this.student = s;
        this.submit = false;
        this.open = true;//Student Can Submit
        this.ungraded = false;//Assign not graded
    }

    public String getProblem() {return Problem;}
    public Student getStudent() {return student;}
    public boolean isSubmit() {return submit;}
    public void setSubmit(boolean submit) {this.submit = submit;}
    public int getMaxMarks() {
        return MaxMarks;
    }
    public void setMaxMarks(int maxMarks) {
        MaxMarks = maxMarks;
    }
    public int getMarksObtained() {
        return MarksObtained;
    }
    public void setMarksObtained(int marksObtained) {
        MarksObtained = marksObtained;
    }
    public boolean isUngraded() {return ungraded;}
    public void setUngraded(boolean ungraded) {
        this.ungraded = ungraded;
    }
    public boolean isOpen() {return open;}
    public void setOpen(boolean open) {
        this.open = open;
    }
    public String  isSubmitted() {return submitted;}
    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }
    public String getInstructor() {return instructor;}

    @Override
    public void viewAssessments(){
        System.out.print( ""+Problem+" Max Marks:"+MaxMarks+"\n");
        System.out.println("----------------------------------------");
    }

    @Override
    public void Grading(int MarksScored,Instructor instructor){
        this.instructor = instructor.getName();
        this.MarksObtained = MarksScored;
        this.setUngraded(true);
        System.out.println("Welcome "+instructor.getName());
    }

    @Override
    public void ViewGrading(){
        System.out.println("Submission:"+isSubmitted());
        System.out.println("Marks Scored"+getMarksObtained());
        System.out.println("Graded by:"+getInstructor());
    }
}

class Quiz implements Assessments{
    private Student student;
    private String Problem;
    private int MaxMarks;
    private int MarksObtained;
    private boolean ungraded;
    private boolean open;
    private String answer;
    private boolean submit;
    private String instructor;

    Quiz(String problem, Student s){
        this.Problem = problem;
        this.MaxMarks = 1;
        this.student = s;
        this.open = true;//Student Can Submit
        this.ungraded = false;//Assign not graded
        this.answer = "";
        this.submit = false;
    }
    public boolean isSubmit() {return submit;}
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Student getStudent() {
        return student;
    }
    public String getProblem() {
        return Problem;
    }
    public int getMaxMarks() {
        return MaxMarks;
    }
    public boolean isUngraded() {
        return ungraded;
    }
    public void setUngraded(boolean ungraded) {
        this.ungraded = ungraded;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public String getInstructor() {
        return instructor;
    }

    @Override
    public void viewAssessments(){
        System.out.println(""+Problem+"");
        System.out.println("----------------------------------------");
    }

    @Override
    public void Grading(int MarksScored,Instructor instructor) {
        this.instructor= instructor.getName();
        this.setUngraded(true);
        System.out.println("Welcome "+instructor.getName());
    }
    @Override
    public void ViewGrading(){
        System.out.println("Submission:"+getAnswer());
        System.out.println("Graded by:"+getInstructor());
    }

}

interface LecturesMaterial {
    void viewMaterial();
}

class Video implements LecturesMaterial{
    private String filename;
    private Instructor instructor;
    private String slides_title;
    Date date = new Date();

    Video(String slides_title,String filename,Instructor instructor){
        this.slides_title = slides_title;
        this.filename = filename;
        this.instructor = instructor;
        this.date = getDate();
    }

    public Instructor getInstructor() {
        return instructor;
    }
    public Date getDate() {
        return date;
    }
    public String toString() {
        return "Welcome " +instructor.getName();
    }

    @Override
    public void viewMaterial(){
        System.out.println("Title of video:"+slides_title);
        System.out.println("Video file:"+filename);
        System.out.println("Date of Upload:"+getDate());
        System.out.println("Uploaded by:"+instructor.getName());
    }
}

class Slides implements LecturesMaterial{

    private Instructor instructor;
    private String slides_title;
    private int no_of_slides;

    private ArrayList<String> content_slides;
    Date date = new Date();

    //Lecture Slides --- instructor

    Slides(String title,int no_of_slides,ArrayList<String> content_slides,Instructor instructor){
        this.instructor = instructor;
        this.date = getDate();
        this.slides_title = title;
        this.no_of_slides = no_of_slides;
        this.content_slides = content_slides;
    }

    @Override
    public void viewMaterial(){
        if(no_of_slides>0) {
            System.out.println("Title:" + slides_title);
            int k = no_of_slides;
            int c = 1;
            while (k-- > 0) {
                System.out.println("Slide:" + c +" "+ content_slides.get(c - 1));
                c++;
            }
            System.out.println("Date of upload:"+getDate());
            System.out.println("Uploaded by:"+instructor.getName());
        }
    }

    public Date getDate() {return date;}
    public String toString() {
        return "Welcome " + instructor.getName();
    }
}

public class Main {

    static int count = 0;

    static void InstructorMenu(){
        System.out.println("""
                  INSTRUCTOR MENU
                1. Add Class Material
                2. Add Assessments
                3. View Lecture Materials
                4. View Assessments
                5. Grade Assessments
                6. Close Assessments
                7. View Comments
                8. Add Comments
                9. Logout""");

    }
    static void StudentMenu(){
        System.out.println("""
                  STUDENT MENU
                1. View Lecture Materials
                2. View Assessments
                3. Submit Assessments
                4. View Grades
                5. View Comments
                6. Add Comments
                7. Logout""");
    }
    public static void main(String[] args) {
        //Objects Created
        Instructor i0 = new Instructor("I0",0);
        Instructor i1 = new Instructor("I1",1);
        ArrayList<Instructor> instructorlist = new ArrayList<>();
        instructorlist.add(i0);
        instructorlist.add(i1);

        Student s0 = new Student("S0",0);
        Student s1 = new Student("S1",1);
        Student s2 = new Student("S2",2);
        ArrayList<Student> student = new ArrayList<>();
        student.add(s0);
        student.add(s1);
        student.add(s2);

        List<Slides> slidesArr = new ArrayList<>();
        List<Video> videoArr = new ArrayList<>();

        ArrayList<Comment> commentArrayList = new ArrayList<>();

        ArrayList<Assignment> AssignObj = new ArrayList<>();
        ArrayList<Quiz> QuizObj = new ArrayList<>();

        Scanner str = new Scanner(System.in);// -------- For Strings
        Scanner sc = new Scanner(System.in); // -------- For Integers
        System.out.print("""
                Welcome to Backpack
                1. Enter as instructor
                2. Enter as student
                3. Exit
                """);
        while(true){
            int option = sc.nextInt();
            if(option==1){InstructorMenu();
                System.out.println("""
                        Instructors:
                        0 - I0
                        1 - I1""");
                int opt = sc.nextInt();
                if(opt>instructorlist.size()) {
                    System.out.println("Wrong Option Entered");
                }
                else {
                    String id = instructorlist.get(opt).getName();
                    System.out.println("Welcome "+id);
                    InstructorMenu();
                    while (true){
                        int Iopt = sc.nextInt();
                        if(Iopt==1) {
                            System.out.println("""
                                    1. Add Lecture Slide
                                    2. Add Lecture Video""");
                            int choice = sc.nextInt();
                            if (choice == 1) {
                                System.out.print("Enter topic of slides:");
                                String topic = str.nextLine();
                                System.out.print("Enter number of slides:");
                                String noofslides = str.nextLine();
                                int no_of_slides = Integer.parseInt(noofslides);
                                System.out.println("Enter content of slides:");
                                int c = count+1;
                                int k = no_of_slides;
                                ArrayList<String> content_slides = new ArrayList<>();
                                while (k-- > 0) {
                                    System.out.print("Content of slide" + c++ +":");
                                    String a = str.nextLine();
                                    content_slides.add(a);
                                }
                                Slides l0 = new Slides(topic, no_of_slides, content_slides, instructorlist.get(opt));
                                slidesArr.add(l0);
                                System.out.println(l0);
                                InstructorMenu();
                            }
                            else if (choice == 2) {
                                System.out.print("Enter topic of video:");
                                String topicV = str.nextLine();
                                System.out.print("Enter filename of video:");
                                String filename = str.nextLine();
                                if (filename.length() < 5) {
                                    System.out.println("Invalid file name !");
                                    break;
                                }
                                String s = filename.substring(filename.length() - 4);
                                if (s.equals(".mp4")) {
                                    Video vids = new Video(topicV, filename, instructorlist.get(opt));
                                    videoArr.add(vids);
                                    System.out.println(vids);
                                } else System.out.println("Wrong File Name !");
                                InstructorMenu();
                            }
                            else System.out.println("No Choice Found");
                        }
                        else if(Iopt==2){//For Assignment
                            System.out.println("""
                                    1. Add Assignment
                                    2. Add Quiz""");
                            int Ioption = sc.nextInt();
                            if(Ioption==1){
                                System.out.print("Enter Problem Statement:");
                                String problem = str.nextLine();
                                System.out.print("Enter Max Marks:");
                                int max = sc.nextInt();
                                System.out.println("Welcome "+instructorlist.get(opt).getName());
                                for (Student s : student) {
                                    Assignment assignment = new Assignment(problem, max, s);
                                    AssignObj.add(assignment);
                                }
                            }
                            else if(Ioption==2){
                                System.out.print("Enter Quiz Question:");
                                String problem = str.nextLine();
                                for (Student s : student) {
                                    Quiz quiz = new Quiz(problem,s);
                                    QuizObj.add(quiz);
                                }
                                System.out.println("Welcome "+instructorlist.get(opt).getName());
                            }
                            else System.out.println("Wrong Option Entered!");
                            InstructorMenu();
                        }
                        else if(Iopt==3){
                            //View Lecture Material
                            int flag = count;
                            for(Slides slide:slidesArr){
                                slide.viewMaterial();
                                flag=1;
                            }
                            System.out.println();
                            for(Video vids:videoArr){
                                vids.viewMaterial();
                                flag=1;
                            }
                            if(flag==0) System.out.println("Empty! Lecture Material");
                            System.out.println("Welcome "+instructorlist.get(opt).getName());
                            InstructorMenu();
                        }
                        else if(Iopt==4){
                            int fl = count;
                            int k = count;
                            //View Assessments
                            if(AssignObj.size()>0){
                                for(int i=0;i<AssignObj.size();i = i+3){
                                    System.out.print("ID:"+k+" ");
                                    AssignObj.get(i).viewAssessments();
                                    k++;
                                }
                                fl = 1;
                            }
                            else System.out.println("No Assignments Exist");
                            if(QuizObj.size()>0){
                                for(int i=0;i<QuizObj.size();i = i+3){
                                    System.out.println("ID:"+k+" ");
                                    QuizObj.get(i).viewAssessments();
                                    k++;
                                }
                                fl = 1;
                            }
                            else if(fl==0){
                                System.out.println("No Assessments Exists-Probably Student is not in IIITD");
                            }
                            InstructorMenu();
                        }
                        else if(Iopt==5){
                            int cc = count;
                            HashMap<Integer,Assignment> hashAssign2 = new HashMap<>();
                            HashMap<Integer,Quiz> hashQuiz2 = new HashMap<>();
                            System.out.println("List Of Open Assessments");
                            if(AssignObj.size()>0){
                                for(int i=0;i<AssignObj.size();i=i+3) {
                                    if(AssignObj.get(i).isOpen()) {
                                        System.out.print("ID:" + cc + " ");
                                        AssignObj.get(i).viewAssessments();
                                        hashAssign2.put(cc, AssignObj.get(i));
                                        cc++;
                                    }
                                }
                            }
                            if(QuizObj.size()>0){
                                for(int j=0;j<QuizObj.size();j=j+3) {
                                    if(QuizObj.get(j).isOpen()){
                                        System.out.print("ID:"+cc+" ");
                                        QuizObj.get(j).viewAssessments();
                                        hashQuiz2.put(cc, QuizObj.get(j));
                                        cc++;
                                    }
                                }
                            }
                            if(cc==0){
                                System.out.println(" Empty ! ");
                                InstructorMenu();
                                break;
                            }
                            System.out.print("Enter the ID of Assessment to View Submissions:");
                            int idd = sc.nextInt();
                            int a = count;
                            if(hashAssign2.get(idd) != null){
                                a = 1;
                            }
                            else if(hashQuiz2.get(idd) != null){
                                a = 2;
                            }
                            if(a==1){//Assignment submissions
                                int x = count;
                                HashMap<Integer,Assignment> evaluate = new HashMap<>();
                                Assignment obj = hashAssign2.get(idd);
                                String prob = obj.getProblem();
                                for (Assignment assignment : AssignObj) {
                                    if (assignment.getProblem().equals(prob)){
                                        boolean sub = assignment.isSubmit();
                                        if(sub){
                                            if(!assignment.isUngraded()){
                                                if(x==0){System.out.println("Choose ID from These Ungraded Submissions:");}
                                                x += 1;
                                                System.out.println(x+"."+assignment.getStudent().getStudent());
                                                evaluate.put(x,assignment);
                                            }
                                        }
                                    }
                                }
                                int choice = sc.nextInt();
                                if(choice>x){
                                    System.out.println("Wrong Choice Entered!");
                                }
                                else{// Assignment Submission---
                                    System.out.println("Submission:");
                                    Assignment assn = evaluate.get(choice);
                                    System.out.println(assn.isSubmitted());
                                    System.out.println("Max Marks:"+assn.getMaxMarks());
                                    System.out.print("Marks Scored:");
                                    int score = sc.nextInt();
                                    assn.Grading(score,instructorlist.get(opt));
                                }
                            }
                            else if(a==2){
                                int y = count;
                                HashMap<Integer,Quiz> evaluation = new HashMap<>();
                                Quiz ob = hashQuiz2.get(idd);
                                String prob = ob.getProblem();
                                for(Quiz quiz:QuizObj){
                                    if(quiz.getProblem().equals(prob)){
                                        boolean sub = quiz.isSubmit();
                                        if(sub){
                                            if(!quiz.isUngraded()){
                                                if(y==0){System.out.println("Choose ID from These Ungraded Submissions:");}
                                                y += 1;
                                                System.out.println(y+"."+quiz.getStudent().getStudent());
                                                evaluation.put(y,quiz);
                                            }
                                        }
                                    }
                                }
                                int choice = sc.nextInt();
                                if(choice>y){
                                    System.out.println("Wrong Choice Entered!");
                                }
                                else{
                                    Quiz q = evaluation.get(choice);
                                    System.out.print("Answer Submitted:"+q.getAnswer());
                                    System.out.println("Max Marks"+q.getMaxMarks());
                                    q.Grading(1,instructorlist.get(opt));
                                }
                            }
                            InstructorMenu();
                        }
                        else if(Iopt==6){
                            int cc = count;
                            HashMap<Integer,Assignment> hashAssign1 = new HashMap<>();
                            HashMap<Integer,Quiz> hashQuiz1 = new HashMap<>();
                            System.out.println("List Of Open Assignment");
                            if(AssignObj.size()>0){
                                for(int i=0;i<AssignObj.size();i=i+3) {
                                    if(AssignObj.get(i).isOpen()) {
                                        System.out.print("ID:" + cc + " ");
                                        AssignObj.get(i).viewAssessments();
                                        hashAssign1.put(cc, AssignObj.get(i));
                                        cc++;
                                    }
                                }
                            }
                            if(QuizObj.size()>0){
                                for(int j=0;j<QuizObj.size();j=j+3) {
                                    if(QuizObj.get(j).isOpen()){
                                        System.out.println("ID:"+cc+" ");
                                        QuizObj.get(j).viewAssessments();
                                        hashQuiz1.put(cc, QuizObj.get(j));
                                        cc++;
                                    }
                                }
                            }
                            if(cc==0){
                                System.out.println("No Assignments to be closed");
                                System.out.print("""
                                    Welcome to Backpack
                                    1. Enter as instructor
                                    2. Enter as student
                                    3. Exit""");
                                break;
                            }
                            System.out.print("Enter the ID of Assessment to Close:");
                            int idd = sc.nextInt();
                            int a = count;
                            if(hashAssign1.get(idd) != null){a = 1;}
                            else if(hashQuiz1.get(idd) != null){a = 2;}
                            if(a==1){//Assignment object
                                Assignment obj = hashAssign1.get(idd);
                                String compare = obj.getProblem();
                                for (Assignment assignment : AssignObj) {
                                    if (assignment.getProblem().equals(compare)) {
                                        assignment.setOpen(false);
                                    }
                                }
                            }
                            else if(a==2){
                                //Quiz object
                                Quiz obj = hashQuiz1.get(idd);
                                String compare = obj.getProblem();
                                for (Quiz quizObj:QuizObj) {
                                    if(quizObj.getProblem().equals(compare)){
                                        quizObj.setOpen(false);
                                    }
                                }
                            }
                            InstructorMenu();
                        }
                        else if(Iopt==7){
                            //View comment
                            if(commentArrayList.size()>0){
                                for (Comment s : commentArrayList) {
                                    System.out.println(s.getData());
                                }
                            }
                            else System.out.println("No Comments Added!");
                            System.out.println("Welcome "+instructorlist.get(opt).getName());
                            InstructorMenu();
                        }
                        else if(Iopt==8){
                            //Add comment
                            System.out.print("Enter Comment:");
                            String comm = str.nextLine();
                            Date d = new Date();
                            String data = comm+" "+id+"\n"+ d;
                            Comment commenting = new Comment(instructorlist.get(opt),data);
                            commentArrayList.add(commenting);
                            System.out.println("Welcome "+instructorlist.get(opt).getName());
                            InstructorMenu();
                        }
                        else if(Iopt==9) {
                            System.out.println("Exiting Instructor");
                            System.out.print("""
                             Welcome to Backpack
                             1. Enter as instructor
                             2. Enter as student
                             3. Exit
                             """);
                            break;
                        }
                    }
                }
            }
            else if(option==2){
                System.out.println("""
                        Students:
                        0 - S0
                        1 - S1
                        2 - S2""");
                System.out.print("Choose Id:");
                int opt = sc.nextInt();
                if(opt>=student.size()) {
                    System.out.println("Wrong Option Entered");
                }
                else {
                    System.out.println("Welcome "+student.get(opt).getStudent());
                    StudentMenu();
                    while (true) {
                        int Sopt = sc.nextInt();
                        if (Sopt == 1) {
                            int flag = 0;
                            for(Slides slide:slidesArr){
                                slide.viewMaterial();
                                flag=1;
                            }
                            for(Video vids:videoArr){
                                vids.viewMaterial();
                                flag=1;
                            }
                            System.out.println("Welcome "+student.get(opt).getStudent());
                            if(flag==0) System.out.println("Empty!");
                            StudentMenu();
                        }
                        else if(Sopt==2){
                            int fl = 0;
                            int k = count;
                            //View Assessments
                            if(AssignObj.size()>0){
                                for(int i=0;i<AssignObj.size();i = i+3){
                                    System.out.print("ID:"+k+" ");
                                    AssignObj.get(i).viewAssessments();
                                    k++;
                                }
                                fl = 1;
                            }
                            else System.out.println("No Assignments Exist");
                            if(QuizObj.size()>0){
                                for(int i=0;i<QuizObj.size();i = i+3){
                                    System.out.print("ID:"+k+" ");
                                    QuizObj.get(i).viewAssessments();
                                    k++;
                                }
                                fl = 1;
                            }
                            else if(fl==0){
                                System.out.println("No Assessments Exists-Probably Student is not in IIITD");
                            }
                            System.out.println("Welcome "+student.get(opt).getStudent());
                            StudentMenu();
                        }
                        else if(Sopt==3){
                            HashMap<Integer,Assignment> hashAssign = new HashMap<>();
                            HashMap<Integer,Quiz> hashQuiz = new HashMap<>();
                            int i = opt;
                            int j = opt;
                            int cc = count;
                            int fl = count;
                            int fl1 = count;
                            if(AssignObj.size()>0){
                                while(i<AssignObj.size()) {
                                    if(!AssignObj.get(i).isSubmit()){
                                        if(AssignObj.get(i).isOpen()) {
                                            System.out.print("ID:" + cc + " ");
                                            AssignObj.get(i).viewAssessments();
                                            hashAssign.put(cc, AssignObj.get(i));
                                            fl1 += 1;
                                            cc++;
                                        }
                                    }
                                    i=i+3;
                                }
                            }
                            if(QuizObj.size()>0){
                                while(j<QuizObj.size()) {
                                    if(!QuizObj.get(j).isSubmit()){
                                        if(QuizObj.get(j).isOpen()){
                                            System.out.print("ID:"+cc+" ");
                                            QuizObj.get(j).viewAssessments();
                                            hashQuiz.put(cc, QuizObj.get(j));
                                            fl+=1;cc++;
                                        }
                                    }
                                    j = j+3;
                                }
                            }
                            if(fl==0 && fl1==0){
                                System.out.println("Nothing Pending ");
                                System.out.println("Welcome "+student.get(opt).getStudent());
                            }
                            else{
                                System.out.print("Enter ID of Assessment:");
                                int getcc = sc.nextInt();
                                if(getcc>cc) {
                                    System.out.println("Wrong Option Entered! Exiting Student");
                                    break;
                                }
                                int a = 0;
                                if(hashAssign.get(getcc) != null){a = 1;}
                                else if(hashQuiz.get(getcc) != null){a = 2;}
                                if(a==1) {//For assignment
                                    Assignment assignment = hashAssign.get(getcc);
                                    System.out.print("Enter FileName Of Assignment:");
                                    String filename = str.nextLine();
                                    if (filename.length() < 5) {
                                        System.out.println("Invalid file name !");
                                        System.out.println("""
                                            Students:
                                            0 - S0
                                            1 - S1
                                            2 - S2
                                            """);
                                        break;
                                    }
                                    String s = filename.substring(filename.length() - 4);
                                    if (s.equals(".zip")) {
                                        if(assignment.isOpen() && !assignment.isUngraded()){
                                            assignment.setSubmitted(filename);
                                            assignment.setSubmit(true);
                                        }
                                        else System.out.println("Assessment Closed Or Already Graded");
                                        //Calling the Grade and submission as true                                         }
                                    }
                                    else System.out.println("Wrong Zip File!");
                                    System.out.println("Welcome "+student.get(opt).getStudent());
                                }
                                else if(a==2){//For Quiz
                                    Quiz quiz = hashQuiz.get(getcc);
                                    System.out.println("ID:"+getcc);
                                    quiz.viewAssessments();
                                    String answer = str.nextLine();
                                    if(answer.contains(" ")){
                                        System.out.println("Wrong Answer!");
                                    }
                                    else if(!quiz.isSubmit() && quiz.isOpen() && !quiz.isUngraded()){
                                        quiz.setAnswer(answer);
                                        quiz.setSubmit(true);
                                    }
                                    else System.out.println("Quiz is Closed OR Already Answered");
                                    System.out.println("Welcome "+student.get(opt).getStudent());
                                }
                            }
                            StudentMenu();
                        }
                        else if(Sopt==4){
                            System.out.println("Graded Submissions");
                            int h = opt;
                            int g = opt;
                            int j = opt;
                            int y = opt;
                            if(AssignObj.size()>0){
                                while(h<AssignObj.size()) {
                                    if(AssignObj.get(h).isSubmit()){
                                        if(AssignObj.get(h).isUngraded()){
                                            AssignObj.get(h).ViewGrading();
                                        }
                                    }
                                    h = h+3;
                                }
                            }
                            if(QuizObj.size()>0) {
                                while (j < QuizObj.size()) {
                                    if (QuizObj.get(j).isSubmit()) {
                                        if (QuizObj.get(j).isUngraded()){
                                            QuizObj.get(j).ViewGrading();
                                        }
                                    }
                                    j = j + 3;
                                }
                            }
                            System.out.println();
                            System.out.println("Ungraded Submissions");
                            if(AssignObj.size()>0){
                                while(g<AssignObj.size()) {
                                    if(AssignObj.get(g).isSubmit()){
                                        if(!AssignObj.get(g).isUngraded()){
                                            System.out.println("Submission:"+AssignObj.get(g).isSubmitted());
                                        }
                                    }
                                    g = g+3;
                                }
                            }
                            if(QuizObj.size()>0) {
                                while (y < QuizObj.size()) {
                                    if (QuizObj.get(y).isSubmit()) {
                                        if (!QuizObj.get(y).isUngraded()){
                                            System.out.println("Submission:"+QuizObj.get(y).getAnswer());
                                        }
                                    }
                                    y = y + 3;
                                }
                            }
                            System.out.println("Welcome "+student.get(opt).getStudent());
                            StudentMenu();
                        }

                        else if(Sopt==5){
                            if(commentArrayList.size()>0){
                                for (Comment s : commentArrayList) {
                                    System.out.println(s.getData());
                                }
                            }
                            else System.out.println("No Comments Added!");
                            System.out.println("Welcome "+student.get(opt).getStudent());
                            StudentMenu();
                        }
                        else if(Sopt==6){
                            System.out.print("Enter Comment:");
                            String comm = str.nextLine();
                            Date d = new Date();
                            String data = comm+" "+"S"+opt+"\n"+ d;
                            Comment commenting = new Comment(student.get(opt),data);
                            commentArrayList.add(commenting);
                            StudentMenu();
                        }
                        else if(Sopt==7) {
                            System.out.println("Exiting Students Section");
                            System.out.print("""
                                 Welcome to Backpack
                                    1. Enter as instructor
                                    2. Enter as student
                                    3. Exit
                                    """);
                            break;
                        }
                        else System.out.println("Wrong Iopt entered!");
                    }
                }
            }
            else if(option==3) break;
            else {
                System.out.println("Wrong Option Entered...Try Again!");
                InstructorMenu();
            }
        }
    }
}
