// Load the IFrame Player API code asynchronously.

document.getElementById("video_submit").onclick = function () {
    var url = this.getElementById("video_url").value;
    sendData({
        user: 1,
        video_url: url
    }, function (xhr) {
        document.getElementById("response_url").innerHTML = xhr.responseText;
        document.getElementById("response_url").setAttribute("style", "display:block");
    });
};

function sendData(value, onSuccess) {
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/savetab", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            onSuccess(xhr);
        }
    };
    xhr.send(value);
}
