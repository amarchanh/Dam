package com.example.juancarlos.informaticavirrey;

public class SubjectDam {

    private String curso;
    private String nombre_dam;
    private String horario_dam;
    private String profesor_dam;
    private String descripcion_dam;

    public static final SubjectDam[] subjectsdam ={
          new SubjectDam(
                  "1ºDAM",
                  "Sistemas Informáticos",
                  "180 horas",
                  "Beatriz Martinez Ruiz",
                  "Descripción Sistemas Informáticos"),
            new SubjectDam(
                    "1º DAM",
                    "Bases de Datos",
                    "185",
                    "Tomas Clemente Carrilero",
                    "Descripción Bases de Datos"),
            new SubjectDam(
                    "1º DAM",
                    "Programación",
                    "205 horas",
                    "Ines Moya Romero",
                    "Descripcion Programación"),
            new SubjectDam(
                    "1º DAM",
                    "Lenguages de marcas y\n sistemas de gestión de información",
                    "134 horas",
                    "Isidro Esteso",
                    "Descripción Lenguages de Marcas"),
            new SubjectDam(
                    "1º DAM",
                    "Entornos de Desarrollo",
                    "110 horas",
                    "Tomas Clemente Carrilero",
                    "Descripción Entornos de Desarrollo"),
            new SubjectDam(
                    "1º DAM",
                    "Inglés Técnico",
                    "64 horas",
                    "Beatriz Martinez Ruiz",
                    "Descripción Ingles Técnico"),
            new SubjectDam(
                    "1º DAM",
                    "Formación y Orientación Laboral",
                    "82 horas",
                    "Caribel Hergueta Camacho",
                    "Descripcion FOL"),
            new SubjectDam(
                    "2º DAM",
                    "Acceso a Datos",
                    "145",
                    "Ines Moya Romero",
                    "Descripcion Acceso a Datos"),
            new SubjectDam(
                    "2º DAM",
                    "Desarrollo de Interfaces,",
                    "130",
                    "Juan Carlos Alumbreros Fresneda",
                    "Descripción Desarrollo de Interfaces"),
            new SubjectDam(
                    "2º DAM",
                    "Programación multimedia y\n dispositivos moviles",
                    "99",
                    "Pedro Andres Mancebo",
                    "Descripción Programación Multimedia"),
            new SubjectDam(
                    "2º DAM",
                    "Programación de servicios y procesos",
                    "65",
                    "Tomás Clemente Carrilero",
                    "Descripción Programación de servicios y procesos"),
            new SubjectDam(
                    "2º DAM",
                    "Sistemas de gestión empresarial",
                    "95",
                    "Montse Gomez Moya",
                    "Descripción Sistemas de Gestión Empresarial")
    };
    private SubjectDam(String curso, String nombre_dam, String horario_dam,
                       String profesor_dam, String descripcion_dam){
        this.curso=curso;
        this.nombre_dam=nombre_dam;
        this.horario_dam=horario_dam;
        this.profesor_dam=profesor_dam;
        this.descripcion_dam=descripcion_dam;
    }
    public String getCurso(){
        return curso;
    }
    public String getNombre_dam(){
        return nombre_dam;
    }
    public String getHorario_dam(){
        return horario_dam;
    }
    public String getProfesor_dam(){
        return profesor_dam;
    }
    public String getDescripcion_dam(){
        return descripcion_dam;
    }
}
