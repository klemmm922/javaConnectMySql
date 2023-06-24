# JE image connection with mysql database

## Environnement local

Le répertoire `local-stack` contient les configurations docker compose utilise pour lancer un environnement local avec :

- Une db mysql 
- Un serveur phpmyadmin pour look ce qu'il y a dans la db


### Lancer l'environnement

```
cd local-stack
```

Pour lancer les containers :
    
    ```
    ./manage_container.sh start
    ```

Pour stopper les services :

    ```
    ./manage_container.sh stop
    ```

### Acceder à phpmyadmin

Se rendre sur le localhost du port 8080

```
http://localhost:8080
```

les identifiants sont :

```
user: root
password: password
```
