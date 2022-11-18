    let loadingImage = document.getElementById('loadingImage')
    setTimeout(() => {
        toggleDisplay()
    }, 2600)

     function toggleDisplay(){
        let wholePage = document.getElementById('wholePage')
        let body = document.querySelector("#body")
        wholePage.classList.toggle("toggleClassDisplay")
        loadingImage.classList.toggle("toggleClassDisplay")
        body.classList.toggle('toggleBG')
     }