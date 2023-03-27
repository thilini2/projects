package hospital_consultation_oop_cw.implementation;

import java.io.IOException;

public interface SkinConsultationManager {

    public void Add_doctor();
    public void Delete_doctor();
    public void View_All_doctors();
    public void Save_file() throws IOException;
    public void Load_file() throws IOException, ClassNotFoundException;

}
