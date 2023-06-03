var sexes;
var diets;

fetch('https://localhost:8443/ProjektTssKucharskiIgorIo3/animals/json/enums')
    .then(response => response.json())
    .then(data => {
        sexes = data.sexes;
        diets = data.diets;
    })
    .catch(error => {
        console.error('Error:', error);
    });

function getAnimalList() {
    fetch('https://localhost:8443/ProjektTssKucharskiIgorIo3/animals/json')
            .then(response => response.json())
            .then((products) => 
                {
                    displayTable(products);
                }
            );
}

function displayTable(data) {
    var out = '<table class="table">' + 
            '<thead class="thead-dark">';
    out += '<tr>' + 
            '<th>ID</th>' + 
            '<th>Species</th>' + 
            '<th>Name</th>' + 
            '<th>Sex</th>' + 
            '<th>Age</th>' + 
            '<th>Weight</th>' + 
            '<th>Diet</th>'+ 
            '<th>Actions</th>' +
            '</tr>' + 
            '</thead>' + 
            '<tbody>';
    
    var i;
    for(i = 0;  i < data.length; i++) {
        out += '<tr>' +
                '<td>' + data[i].id + '</th>' +
                '<td><input type="text" id="species_' + data[i].id + '" value="' + data[i].species + '" size="20"></td>' +
                '<td><input type="text" id="name_' + data[i].id + '" value="' + data[i].name + '" size="20"></td>' +                
                '<td>' +
                    '<select id="sex_' + data[i].id + '">';
                    sexes.forEach(function(sex) {
                        out += '<option value="' + sex + '"';
                        if(sex === data[i].sex)
                            out += ' selected';
                        out += '>' + sex + '</option>';
                    });
                    out +=
                    '</select>' +
                '</td>' +
                '<td><input type="text" id="age_' + data[i].id + '" value="' + data[i].age + '" size="20"></td>' +
                '<td><input type="text" id="weight_' + data[i].id + '" value="' + data[i].weight + '" size="20"></td>' +
                '<td>' +
                    '<select id="diet_' + data[i].id + '">';
                    diets.forEach(function(diet) {
                        out += '<option value="' + diet + '"';
                        if(diet === data[i].diet)
                            out += ' selected';
                        out += '>' + diet + '</option>';
                    });
                    out +=
                    '</select>' +
                '</td>' +
                '<td>' +
                    '<button type="button" onclick="updateProduct(' + data[i].id + ');"><i class="fas fa-user-edit ml-1"></i></button>' +
                    '<button type="button" onclick="deleteProduct(' + data[i].id + ');"><i class="fas fa-user-times ml-1"></i></button>' +
                '</td>' +
                '</tr>';
    }
    out += '</tbody>' + 
            '</table>';
    document.getElementById("result").innerHTML = out;
}

function createProduct() {
    fetch('https://localhost:8443/ProjektTssKucharskiIgorIo3/animals/json',
        {
            method: 'POST',
            body: JSON.stringify({
                id: -1,
                species: 'Enter species',
                name: 'Enter a name',
                sex: '0',
                age: '0',
                weight: '0.0',
                diet: 'Carnivore'
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }
    )
    .then(response => response.json)
    .then(data => console.log(data));
}

function updateProduct(id) {
    fetch('https://localhost:8443/ProjektTssKucharskiIgorIo3/animals/json/' + id,
        {
            method: 'PUT',
            body: JSON.stringify({
                id: id,
                species: document.getElementById("species_" + id).value,
                name: document.getElementById("name_" + id).value,
                sex: document.getElementById("sex_" + id).value,
                age: document.getElementById("age_" + id).value,
                weight: document.getElementById("weight_" + id).value,
                diet: document.getElementById("diet_" + id).value
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }
    )
    .then(response => response.json)
    .then(data => console.log(data));
}

function deleteProduct(id) {
    fetch('https://localhost:8443/ProjektTssKucharskiIgorIo3/animals/json/' + id,
        {
            method: 'DELETE'
        });
}

window.addEventListener("load", getAnimalList, false);