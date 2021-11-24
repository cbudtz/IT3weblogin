async function login() {
    let loginForm = document.getElementById("loginform");
    let formData = new FormData(loginForm);
    let formObject = Object.fromEntries(formData);
    console.log(formObject);
    const res =await fetch("api/login", {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify(formObject)
    })
    localStorage.setItem("token",await res.text())

}