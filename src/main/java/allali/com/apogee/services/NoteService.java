package allali.com.apogee.services;

public interface NoteService {
    public void initStudents();
    public void initProfs();
    public void initModules();
    public void initNotes();
    public Double moyenSemestre();
    public void initFilliéres();
    public void addStudentToModule(long id , long idModu);
    public void addProfToModule(long id , long idModu);

}
