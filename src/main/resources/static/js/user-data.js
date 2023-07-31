const roles = document.getElementById('roles').innerText;
const active = document.getElementById('active').innerText;
const managerButton = document.getElementById('manager-button');
const blockButton = document.getElementById('block-button');
const deleteButton = document.getElementById('delete-button');

if (roles !== null && roles.includes('MANAGER')) {
    managerButton.innerText = 'Remove manager';
}

if (active !== null && active === 'false') {
    blockButton.innerText = 'Unblock user';
}

managerButton.addEventListener('click', checkConfirm, false);
blockButton.addEventListener('click', checkConfirm, false);
deleteButton.addEventListener('click', checkConfirm, false);

function checkConfirm(event) {
    if (!confirm('Are you sure?')) {
        event.preventDefault();
    }
}