package sample;

public class cst2 {
    String eno,col2,col3,col4,col5,col6,col7,gpa;

    public String getEno() { return eno; }

    public void setEno(String eno) { this.eno = eno; }

    public String getCol2() { return col2; }

    public void setCol2(String col2) { this.col2 = col2; }

    public String getCol3() { return col3; }

    public void setCol3(String col3) { this.col3 = col3; }

    public String getCol4() { return col4; }

    public void setCol4(String col4) { this.col4 = col4; }

    public String getCol5() { return col5; }

    public void setCol5(String col5) { this.col5 = col5; }

    public String getCol6() { return col6; }

    public void setCol6(String col6) { this.col6 = col6; }

    public String getCol7() { return col7; }

    public void setCol7(String col7) { this.col7 = col7; }

    public String getGpa() { return gpa; }

    public void setGpa(String gpa) { this.gpa = gpa; }

    public cst2(String stuno, String SystemAnalysisandDesign, String Programming, String Network2, String StaticalMethod, String SoftwareEngineering, String AestheticStudies, String gpa) {
        this.eno = stuno;
        this.col2 = SystemAnalysisandDesign;
        this.col3 = Programming;
        this.col4 = Network2;
        this.col5 = StaticalMethod;
        this.col6 = SoftwareEngineering;
        this.col7 = AestheticStudies;
        this.gpa = gpa;
    }

}
