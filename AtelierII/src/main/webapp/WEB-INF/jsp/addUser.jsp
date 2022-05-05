
<!DOCTYPE html>
<html>
    <head>
        <!-- Standard Meta -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!-- Site Properties -->
        <title>Grid Example - Semantic</title>

        <link rel="stylesheet" type="text/css" href="/lib/Semantic-UI-CSS-master/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="/css/custom.css">

    </head>

    <body>
        <div class="ui three column grid">
            <div class="row"></div>
            <div class="column"></div>
            <div class="column">

                <form class="ui form" action="SignedUpServlet" method="POST">
                    <fieldset>
                    <legend>UserForm</legend>
                    <div class="field">
                        <label>Name</label>
                        <input type="text" name="first-name" placeholder="Name">
                    </div>
                    <div class="field">
                        <label>Surname</label>
                        <input type="text" name="last-name" placeholder="Surname">
                    </div>
                       <div class="field">
                        <label for="password">Password</label>
                        <input id="password" type="password" name="password" placeholder="Password">
                    </div>
                      <div class="field">
                        <label for="confirm_password">Re-Password</label>
                        <input id="confirm_password" type="password" name="confirm_password" placeholder="Confirm your password">
                    </div>
                    
					<div class="ui grid">
						<div class="four column row">
							<button class="ui button left floated column" type="reset" >Cancel</button>  
							<button class="ui button right floated column" type="submit" ><i class="plus icon"></i>OK</button>
						</div>
					</div>

                    </fieldset>
                </form>
            </div>
        </div>
    </body>
</html>