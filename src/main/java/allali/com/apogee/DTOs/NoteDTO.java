package allali.com.apogee.DTOs;

import allali.com.apogee.entities.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long id;
    private Double noteFinale;
    // You can include other necessary fields if needed

    public static NoteDTO from(Note note) {
        return new NoteDTO(note.getId(), note.getNoteFinale());
    }
}