# Programming languages auto-complete

## Description
This project implements a Trie data structure to store words. 
The suggestions are based on the words stored in the Trie.

## Run the app
```docker-compose -up```

## Requests
```curl -X GET http://localhost:8080/suggestions?prefix=j```
```curl -X GET http://localhost:8080/suggestions?prefix=J```
```curl -X GET http://localhost:8080/suggestions?prefix=C```

## Stop the app
```docker-compose down```