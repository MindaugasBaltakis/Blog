
loadPosts();



function loadPosts() {
    let container = document.getElementById("post-container")
    fetch('api/posts')
        .then(response => response.json())
        .then(function (resp) {
            resp.forEach(function (x) {
                container.innerHTML += 
            `<div class="inner">
                <div class="section">
                    <div class="container">
                        <div class="date">${x.date}</div>
                        <h2 class="title">${x.title}</h2>
                        <p>${x.article}</p>
                    </div>
                </div>
            </div>`
            });
        })
}
