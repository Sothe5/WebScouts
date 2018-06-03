function validateChanges()
{
    var name = document.getElementById("pef:name").value;
    var pass = document.getElementById("pef:pass").value;
    var pass1 = document.getElementById("pef:pass1").value;

    if (name && name.length < 4)
    {
        alert("El nombre de usuario debe tener al menos 4 caracteres");
        return false;
    }
    
    if ((pass && !pass1) || (!pass && pass1))
    {
        alert("Tienes que escribir las contrasenias en ambos campos");
        return false;
    }
    
    if (pass && pass.length < 4)
    {
        alert("La contrasenia debe tener al menos 4 caracteres");
        return false;
    }
      
    if (pass !== pass1)
    {
        alert("Las contrasenias no coinciden");
        return false;
    }
    
    if (pass && pass.length < 4)
    {
        alert("La contrasenia debe tener al menos 5 caracteres");
        return false;
    }
    
    return true;
}
