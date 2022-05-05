<!DOCTYPE html>
<html>
    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!-- Site Properties -->
        <title>Login Page</title>

        <link rel="stylesheet" type="text/css" href="/lib/Semantic-UI-CSS-master/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="/css/custom.css">

    </head>

    <body>
        <div class="ui three column grid">
            <div class="row"></div>
            <div class="column"></div>
            <div class="column">

                <form class="ui form" action="login" method="POST">
                    <fieldset>
                    <legend>Login</legend>
 
                    <div class="field">
                        <label>Surname</label>
                        <input type="text" name="last-name" placeholder="Surname">
                    </div>
                       <div class="field">
                        <label for="password">Password</label>
                        <input id="password" type="password" name="password" placeholder="Password">
                    </div>

      				<button class="ui button" type="submit" ><i class="sign-in icon"></i>Connect</button>
                    <button class="ui button" type="reset" >Cancel</button>
                               
                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>