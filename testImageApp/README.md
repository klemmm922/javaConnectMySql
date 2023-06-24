# JE image connection with mysql database

En gros je vous met la config comme si vous n'aviez pas deja le .jar dans le repo comme ca vous voyez comment faire. Mais vous l'avez deja donc vous pouvez skip la partie download connector.
Voila la vidéo que j'ai use comme exemple si vous avez besoin de check un truc : https://www.youtube.com/watch?v=e8g9eNnFpHQ


### download java connector for mysql

If the jar file is not in the lib folder :

Donwload the zip format (the second link on the page) : https://dev.mysql.com/downloads/connector/j/
Once downloaded, go to the install folder (exemple for me : Program Files (x86)/MySQL/Connector J 8.0 ) and copy the jar file inside to the lib folder of the project.

Else :
u'r good 

### Intellij setup 

If u're using intellij IDE, you will have to add the jar file to the project.

Go to file -> project structure -> modules -> dependencies : click on the + button and select the jar file.
Don't forgot to select it and apply before leaving the page.

