# Crud-Api
practice building restful CRUD APIs

## Api Endpoints
Using postman to try the following endpoints:

## Get list of Animals

### Request 
'Get /api/animals'

'http://localhost:8080/api/animals'

### Response
[
{"animalId":2,
"name":"Tiger",
"scientificName":"Panthera tigris",
"species":"Mammal",
"habitat":"Forest",
"description":"The tiger is the largest sapecies among the felines"},
{"animalId":3,
"name":"Elephant",
"scientificName":"Loxodonta africana"
,"species":"Mammal",
"habitat":"Savannah",
"description":"Largest land animal"}
]

## Get a specific animal

### Request 

'Get /api/animals/4'

http://localhost:8080/api/animals/4

### Response
{
"animalId":4,
"name":"Seahorse",
"scientificName":"Hippocampus",
"species":"Fish",
"habitat":"Shallow Coastal Waters",
"description":"A small marine fish known for its horse-like head."
}

## Create a new Animal

### Request
'Post /api/animals  --data {"name":"Great White Shark","scientificName":"Carcharodon carcharias","species":"Fish","habitat":"Coastal Waters","description":"A large predatory fish known for its sharp teeth and powerful body."}'

### Response
{"animalId:...",
"name":"Great White Shark",
"scientificName":"Carcharodon carcharias",
"species":"Fish",
"habitat":"Coastal Waters",
"description":"A large predatory fish known for its sharp teeth and powerful body."}

## Updating an existing animal

### Request
'Put /api/animals/{id} --data {"name": "Big Greate white Shark", 
"scientificName": "Squalus carcharias Linnaeus", 
"species": "large mackerel", 
"habitat":"Coastal surface waters", 
"description":"The great white shark is arguably the world's largest-known extant macropredatory fish, and is one of the primary predators of marine mammals"}

### Response

{
"animalId":....
"name": "Big Greate white Shark", 
"scientificName": "Squalus carcharias Linnaeus", 
"species": "large mackerel", 
"habitat":"Coastal surface waters", 
"description":"The great white shark is arguably the world's largest-known extant macropredatory fish, and is one of the primary predators of marine mammals"
}

## Delete an animal

### Request 
'Delete /api/animals/{id}'

### Response 
The animal is deleted from the database

## Get all animal of a given species

### Request
'Get /api/animals/species/{species}'

'http://localhost:8080/api/animals/species/fish'

### Response
A listing of species that has fish in ther species category

## Get animals whose name contains a satring

### Request
'Get /api/animals/search?name=Frog'

'http://localhost:8080/api/animals/search?name=Lion'

### Resonse
Will give you a list with the key string frog in it
