# Project_Mercalibre_mobile
Challenge Android Mobile


Reclutamiento para desarrrollo de aplicaciones moviles en ambiente android dicha aplicacion se desarrollo en 2 lenguajes 
JAVA Y KOTLIN  se usaron patrones aquitectonicos pero primero hay que explicar brevemente de lo que se compone un patron 

![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/7f5ad941-b2e9-40ed-a843-245dbd3c3a39)


¿Qué es un patrón arquitectónico?
Según Wikipedia,
Un patrón arquitectónico es una solución general y reutilizable a un problema común en la arquitectura de software dentro de un contexto dado. Los patrones arquitectónicos son similares al patrón de diseño de software, pero tienen un alcance más amplio.


Hay cuatro elementos principales que un patrón arquitectónico debe proveer a un sistema.

Independiente del framework: La arquitectura de su sistema debe ser independiente de librerías externas o frameworks. Esto le permite poder sustituir en el futuro facilmente.
Testable: Las reglas de negocio se deben poder probar sin necesidad de la UI, base de datos, API u otro elemento externo.
Independencia de la interfaz de usuario: La interfaz de usuario se debería poder cambiar sin requerir modificar sus reglas de negocio ni el resto del sistema.
Independencia de la base de datos: En cualquier momento puede cambiar su gestor de base de datos y su regla de negocio no debe sufrir ningún impacto.
Independiente de cualquier agencia externa: Simple, las reglas de negocio de su aplicación no debe saber nada del mundo exterior.


 A continuación, nombraré los que a mi opinión personal son los más importantes y utilizados al día de hoy en el desarrollo de aplicaciones Android.

        Model View Controller (MVC)
        Model View Presenter (MVP)
        Model View View Model (MVVM)
        Clean Architecture

y ahora que son los patrones de diseño
Los patrones de diseño o design patterns, son una solución general, reutilizable y aplicable a diferentes problemas de diseño de software. Se trata de plantillas que identifican problemas en el sistema y proporcionan soluciones apropiadas a problemas generales a los que se han enfrentado los desarrolladores durante un largo periodo de tiempo, a través de prueba y error.

Tipos de patrones de diseño de sotware
Los patrones de diseño más utilizados se clasifican en tres categorías principales, cada patrón de diseño individual conforma un total de 23 patrones de diseño. Las cuatro categorías principales son:

    Patrones creacionales
    Patrones estructurales
    Patrones de comportamiento
![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/5e65b965-8718-401a-a3d3-2a8b7cbb8bf0)

En todo el proyecto se usaron los 3 tipos de patrones en los que destacan los siguientes:
 
Patrones creacionales
Los patrones de creación proporcionan diversos mecanismos de creación de objetos, que aumentan la flexibilidad y la reutilización del código existente de una manera adecuada a la situación. Esto le da al programa más flexibilidad para decidir qué objetos deben crearse para un caso de uso dado.
Estos son los patrones creacionales que se usaron en el proyecto:

     Abstract Factory
        En este patrón, una interfaz crea conjuntos o familias de objetos relacionados sin especificar el nombre de la clase.
    
     Builder Patterns
          Permite producir diferentes tipos y representaciones de un objeto utilizando el mismo código de construcción. Se utiliza para la creación etapa por etapa de un objeto complejo combinando objetos simples. La creación final de objetos depende de las etapas del proceso creativo, pero es independiente de otros objetos.
    
      Ahora en los patrones estructurales
    Adapter
      Se utiliza para vincular dos interfaces que no son compatibles y utilizan sus funcionalidades. El adaptador permite que las clases trabajen juntas de otra manera que no podrían al ser interfaces incompatibles.

    Para finalizar el de Comportamiento
      Iterator
          Su utilidad es proporcionar acceso secuencial a un número de elementos presentes dentro de un objeto de colección sin realizar ningún intercambio de información relevante.
      State
            En el patrón state, el comportamiento de una clase varía con su estado y, por lo tanto, está representado por el objeto de contexto.
                    
# IMGENES DE LA APLICACION Y CONCLUSIONES
# INTRO
Da un poco de contexto amplio de lo que tiene la aplicacion

![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/422eff06-4f81-487e-850a-6547a776e723)
  
  
# LOGIN 
El inicio de sesion contiene credenciales de acceso para poder entrar la aplicacion el usuario es TEST y el passwowrd TEST
contiene mensajes Toast personalidas que tambien van en esta seccion Ademas de contener animaciones para una mejor experiencia de usuario

![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/e482d9a3-0d41-4ccb-9609-9bc513470888)
![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/3807f440-d99a-4f10-af80-a026d0afe69b)
![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/b25adb9d-7dba-42aa-93ee-cc9b758644f9)

# DASHBOARD

![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/0291c65f-3365-435b-8a54-a9971ab90ea7)
![image](https://github.com/SalvadorAgs/Project_Mercalibre_mobile/assets/46586520/911c5e4f-ae2d-4f0b-8791-1a6445b68ec5)


# PRODUCT DETAIL


# Anexos 
* Ademas de todo eso Se incoporaron otras cosas
* Imagnes Responsive para cualquier resolucion de android
* Se usuaron las lambdas para una mejor legibilidad de codigo
* Fuente para un mejor diseño 
* Todas las vistas deben de ser resposive
* XNK con Constraintlayout para una mejor cobertura y render.








