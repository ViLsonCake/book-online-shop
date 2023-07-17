const params = window.location.search.replace('?', '');

if (params === 'error') {
    document.getElementById('error-box').innerText = 'Incorrect username or password'
}