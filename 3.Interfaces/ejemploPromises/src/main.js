//fetch("https://www.boredapi.com/api/activity")
//.then(response => response.json)
//.then(data => 
//    document.getElementById("bored").textContent = data.activity)


async function getBoredActivity() {
    try {
        const response = await fetch("https://www.boredapi.com/api/activity");
        const data = await response.json();
        return {activity: data.activity, error: false};
    } catch (error) {
        return {info: "No se ha podido descargar",error: true}
    }
    
}

async function createDom() {
    const data = await getBoredActivity();
    if (! data.error) {
        const negrita = "<b>" + data.activity + "</b>"
        document.getElementById("bored").innerHTML = negrita;
    }else {
        
    }
    
}

createDom();



//getBoredActivity()
//.then((activity) => {
//const negrita = "<b>" + data.activity + "</b>"
//document.getElementById("bored").innerHTML = negrita;
//})

