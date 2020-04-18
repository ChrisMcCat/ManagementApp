<html lang="en">
<head>
    <title>Edit Trainer</title>
</head>
<body>
<div style="text-align: center;">
    <form name="loginForm" method="post" action="/ManagementApp-1.0-SNAPSHOT/edit">
        <br/><br/><br/>
        Name: <label>
            <input type="text" value="${trainer.name}" name="name"/>
        </label> <br/>
        Surname: <label>
            <input type="text" value="${trainer.surname}" name="surname"/>
        </label> <br/>
        Phone Number: <label>
            <input type="text" value="${trainer.phoneNumber}" name="phoneNumber"/>
        </label> <br/>
        E-mail: <label>
            <input type="text" value="${trainer.mail}" name="mail"/>
        </label> <br/>
        <input type="submit" value="Save"/>
    </form>
</div>
</body>
</html>