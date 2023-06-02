#language: es

  Característica: Agregar un nuevo producto de forma exitosa

    Antecedentes:
      Dado que el usuario abra el navegador en la url y ingrese las credenciales y el usuario de click en inicar sesion

    Escenario: Agregar un nuevo producto de forma exitosa
      Cuando el usuario de click en la categoria de productos
      Y el usuario de click en Nuevo producto y el usuario ingrese los campos obligatorios y de click en guardar
      Entonces el usuario podra visualizar el nombre del nuevo producto