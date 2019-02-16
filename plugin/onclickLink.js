var icon = document.createElement("img");
icon.setAttribute("src", "data:image/png;base64,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");
icon.setAttribute("style", "display:none;");


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
                ]
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
