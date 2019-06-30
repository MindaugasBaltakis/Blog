

loadPosts();



function loadPosts() {
    let container = document.getElementById("post-container");
    container.innerHTML = "";
    fetch('api/user/posts')
        .then(response => response.json())
        .then(function (resp) {
            resp.forEach(function (x) {
                container.innerHTML += 
                `<div class="inner">
                    <div class="section">
                    <div class="container">
                        <div class="date">${x.date} by ${x.author.username}</div>
                        <h2 class="title">${x.title}</h2>
                        <p>${x.article}</p>
                        <button onclick="updatePost(${x.id})">UPDATE</button>
                        <button onclick="deletePost(${x.id})">DELETE</button>
                    </div>
                </div>
                </div>`
            });
        })
}

function deletePost(id) {
    fetch(`api/post/${id}`, {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json'}})
        .then(() => loadPosts());

}

function updatePost({id}) {
//TODO
}

function createPost() {
    let title = document.getElementById("title");
    let article = document.getElementById("article");
    fetch(`api/post`, {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({title: title.value, article: article.value})
    })
        .then(() => loadPosts());

    title.value = "";
    article.value = "";
}