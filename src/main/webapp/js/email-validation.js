function ValidateEmail(inputText, input)
{
    let regExp = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return false;

    if(inputText.value.match(regExp))
    {
        console.log("asdsadsa")
        alert("valid");
        return true;
    }
    else
    {
        console.log("invalid")

        alert("You have entered an invalid email address!");
        input.focus();
        return false;
    }
}