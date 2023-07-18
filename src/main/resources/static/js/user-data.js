const roles = document.getElementById('roles').innerText;
const active = document.getElementById('active').innerText;
const managerButton = document.getElementById('manager-button');
const blockButton = document.getElementById('block-button');

if (roles !== null && roles.includes('MANAGER')) {
    managerButton.innerText = 'Remove manager';
}

if (active !== null && active === 'false') {
    blockButton.innerText = 'Unblock user';
}