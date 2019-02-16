// chrome.webRequest.onBeforeRequest.addListener(function (details) {
//     var scheme = /^https/.test(details.url) ? 'https' : 'http';
//     return {redirectUrl: 'javascript:void(0)'};
// }, {
//     urls: ['https://stackoverflow.com/*'] // Example: Block all requests to YouTube
// }, ['blocking']);
