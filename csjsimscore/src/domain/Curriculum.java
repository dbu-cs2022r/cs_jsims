package domain;

public class Curriculum {

    int id;
    String nomenclature;
    int stayYear;
    int staySemester;
    int totalCredit;
    String version;
    int programStudyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(String nomenclature) {
        this.nomenclature = nomenclature;
    }

    public int getStayYear() {
        return stayYear;
    }

    public void setStayYear(int stayYear) {
        this.stayYear = stayYear;
    }

    public int getStaySemester() {
        return staySemester;
    }

    public void setStaySemester(int staySemester) {
        this.staySemester = staySemester;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getProgramStudyId() {
        return programStudyId;
    }

    public void setProgramStudyId(int programStudyId) {
        this.programStudyId = programStudyId;
    }

}
