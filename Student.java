package java101;

public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;
    double fizik_sözlü_etkisi=20;
    double kimya_sözlü_etkisi=20;
    double mat_sözlü_etkisi=20;
    


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat,int fizik,int kimya,int verbal1, int verbal2,int verbal3) {
        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
            this.mat.verbal=verbal1;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
            this.fizik.verbal=verbal2;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
            this.kimya.verbal=verbal3;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
       
    	
    double fizik_genel_not=this.fizik.note*(100-fizik_sözlü_etkisi)/100 + (this.fizik.verbal*fizik_sözlü_etkisi)/100;
    double kimya_genel_not=this.kimya.note*(100-kimya_sözlü_etkisi)/100 + (this.kimya.verbal*kimya_sözlü_etkisi)/100;
    double mat_genel_not=this.mat.note*(100-mat_sözlü_etkisi)/100 + (this.mat.verbal*mat_sözlü_etkisi)/100;	
    this.avarage = (fizik_genel_not+kimya_genel_not+mat_genel_not)/3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        double etki1=((100-mat_sözlü_etkisi)/100);
        double etki2=(mat_sözlü_etkisi/100);
        double etki3=(fizik_sözlü_etkisi/100);
        double etki4=(kimya_sözlü_etkisi/100);
        double etki5=((100-fizik_sözlü_etkisi)/100);
        double etki6=((100-kimya_sözlü_etkisi)/100); 
         
        double fizik_genel_not=(this.fizik.note*etki5)+ (this.fizik.verbal*etki3);
        double kimya_genel_not=(this.kimya.note*etki6) + (this.kimya.verbal*etki4);
        double mat_genel_not=(this.mat.note*etki2) + ((this.mat.verbal*etki1));	
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + mat_genel_not);
        System.out.println("Fizik Notu : " + fizik_genel_not);
        System.out.println("Kimya Notu : " + kimya_genel_not);
    }

}