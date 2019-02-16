
hrefs = document.getElementsByTagName("a");
for (var i = 0; i < hrefs.length; i++) {
    hrefs[i].onclick = function (e) {
        if (e.target.href.startsWith("https")) {
            e.preventDefault();
            // getData(e.target.href);
            y = 100;
            x = 100;
            data = {
                video_url: "znndAqodb_0",
                start: 506,
                comments: [
                    "Test",
                    "Test"
                ],
                stars: 6

            };
            var extensionOrigin = 'chrome-extension://' + chrome.runtime.id;
            if (!location.ancestorOrigins.contains(extensionOrigin)) {
                if (document.getElementById("wrapper") != null) {
                    //remove the previous
                    document.getElementById("wrapper").remove();
                }
                var wrapper = document.createElement("div");
                wrapper.innerHTML = "<nav class=\"navbar navbar-expand-lg\">\n" +
                    "    <div class=\"navbar-brand\">Nobody</div>\n" +
                    "    <div class=\"col-sm-4\">\n" +
                    "        <div class=\"float-right\" id=\"close\">\n" +
                    "            <button type=\"button\" class=\"close\" aria-label=\"Close\">\n" +
                    "                <span aria-hidden=\"true\">&times;</span>\n" +
                    "            </button>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "\n" +
                    "</nav>";
                wrapper.setAttribute("id", "wrapper");
                var iframe = document.createElement('iframe');
                iframe.setAttribute("id", "mol-iframe");
                // Must be declared at web_accessible_resources in manifest.json
                iframe.src = chrome.runtime.getURL('frame.html?videoUrl=' + data.video_url + '&start=' + data.start);
                // Some styles for a fancy sidebar
                iframe.style.cssText = 'width:600px;height:600px;';
                wrapper.style.cssText = 'position:fixed;display:block;' +
                    'z-index:1000;' + `top:${y - 20}px;left:${x + 40}px;`;
                wrapper.append(iframe);
                document.body.append(wrapper);
                if(data.comments.length > 0){
                    var commentList = document.createElement("ul");
                    for(var i = 0;i < data.comments.length; i++){
                        commentList.append("<li>" + data.comments + "</li>")
                    }
                    wrapper.append(commentList);
                }
                if(data.stars != 0){

                }
                document.querySelector('#close').addEventListener('click', function () {
                    document.getElementById("wrapper").remove();
                });
            }
        }
    }
}


function getData(url) {
    var xhf = new XMLHttpRequest();
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            y = 100;
            x = 100;
            var extensionOrigin = 'chrome-extension://' + chrome.runtime.id;
            if (!location.ancestorOrigins.contains(extensionOrigin)) {
                if (document.getElementById("wrapper") != null) {
                    //remove the previous
                    document.getElementById("wrapper").remove();
                }
                var wrapper = document.createElement("div");
                wrapper.innerHTML = "<script type=\"text/javascript\" src=\"bootstrap.bundle.js\"></script>" +
                    "<nav class=\"navbar navbar-expand-lg \">\n" +
                    "    <div class=\"navbar-brand\">Nobody</div>\n" +
                    "    <div class=\"col-sm-4\">\n" +
                    "        <div class=\"float-right\" id=\"close\">\n" +
                    "            <button type=\"button\" class=\"close\" aria-label=\"Close\">\n" +
                    "                <span aria-hidden=\"true\">&times;</span>\n" +
                    "            </button>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "\n" +
                    "</nav>";
                wrapper.setAttribute("id", "wrapper");
                var iframe = document.createElement('iframe');
                iframe.setAttribute("id", "mol-iframe");
                // Must be declared at web_accessible_resources in manifest.json
                iframe.src = chrome.runtime.getURL('frame.html?videoUrl=' + data.video_url);
                // Some styles for a fancy sidebar
                iframe.style.cssText = 'width:600px;height:600px;';
                wrapper.style.cssText = 'position:fixed;display:block;' +
                    'z-index:1000;' + `top:${y - 20}px;left:${x + 40}px;`;
                wrapper.append(iframe);
                document.body.append(wrapper);
                document.querySelector('#close').addEventListener('click', function () {
                    document.getElementById("wrapper").remove();
                });
            }
        }
    };
    xhr.send();
}
