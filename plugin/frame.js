document.addEventListener('DOMContentLoaded', function () {
    main();
});


function close() {
    document.getElementsByTagName("html")[0].setAttribute("style", "display:none;");
}

function main() {
    console.log("Yeah");
    var url = window.location.search.substring(1); //get rid of "?" in querystring
    var qArray = url.split('&'); //get key-value pairs
    var youtubeId = "";
    var startTime = "";
    var endTime = "";
    for (var i = 0; i < qArray.length; i++) {
        var pArr = qArray[i].split('='); //split key and value
        if (pArr[0] === "videoUrl") {
            youtubeId = pArr[1];
        }
        if (pArr[0] === "start") {
            startTime = pArr[1];
        }
        if (pArr[0] === "end") {
            endTime = pArr[1];
        }

    }
    var src = `https://www.youtube.com/embed/${youtubeId}?start=${startTime}&end=${endTime}&autoplay=1`;
    console.log(src);
    document.getElementById("ytplayer").setAttribute("src", src);
    // document.getElementById("text").textContent = "About " + selectedText + " , We find following may interest you";
}

