
const jsonData = {
    "jallikattu": ["a", "jallikattu", "arena", "tamil", "n", "nadu", "has", "new", "government", "sport"],
            "madurai": ["chennai", "a", "their", "region", "n", "u2019s", "events", "s", "championship", "its"],
            "metro": ["metro", "expansion", "will", "chennai", "a", "n", "new", "project", "city", "have"],
            "ministers": ["government", "employees", "have", "a", "will", "n", "pension", "their", "tamil", "nadu"],
            "murata": ["india", "murata", "a", "manufacturing", "u2019s", "its", "n", "electronics", "factory", "production"],
            "phoenix": ["u2019s", "footwear", "nadu", "a", "tamil", "n", "phoenix", "kothari", "industrial", "investment"],
            "sports": ["n", "a", "pakistan", "india", "u2019s", "be", "match", "will", "both", "are"],
            "stalin": ["legal", "bill", "advocates", "n", "government", "profession", "have", "a", "stalin", "has"],
            "trains": ["devotees", "n", "special", "palani", "railways", "festival", "will", "trains", "thaipoosam", "temple"],
            "tvk": ["n", "a", "tvk", "has", "u2019s", "its", "party", "tamil", "nadu", "political"],
            "bridge": ["bridges", "will", "districts", "connectivity", "flood", "n", "tamil", "nadu", "34", "u20b9177"],
            "electronic": ["electronics", "nadu", "tamil", "a", "its", "sector", "india", "u2019s", "n", "state"]
};

function searchFunction() {
    let query = document.getElementById("search-input").value.toLowerCase();
    let matchedKey = "";
    
    for (let key in jsonData) {
        if (jsonData[key].some(word => word.includes(query))) {
            matchedKey = key;
            break;
        }
    }
    
    if (matchedKey) {
        localStorage.setItem('newsId', matchedKey);
        window.location.href = "news.html";
    }
}

document.addEventListener("DOMContentLoaded", function () {
    let newsId = localStorage.getItem('newsId');
    if (!newsId) return;

    fetch(`news-content/${newsId}.json`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('news-title').innerText = data.heading;
            document.getElementById('news-content').innerText = data.paragraph;
            
            if (data.image) {
                let newsImage = document.getElementById('news-image');
                newsImage.src = data.image;
                newsImage.style.display = "block";
            }
        })
        .catch(error => console.error("Error loading news:", error));
});




  
