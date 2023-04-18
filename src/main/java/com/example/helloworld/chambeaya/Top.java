package com.example.helloworld.chambeaya;


    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Top {
  private int id;
  private int idAnuncio;
  private int idUser;
  private String nombre;
  private String apePaterno;
  private String apMaterno;
  private String calficacion;

}
