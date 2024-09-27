document.getElementById('addTaskButton').addEventListener('click', addTask);

function addTask() {
    const taskInput = document.getElementById('taskInput');
    const taskValue = taskInput.value;

    if (taskValue === '') {
        alert('Please enter a task!');
        return;
    }

    // Create list item
    const li = document.createElement('li');
    li.textContent = taskValue;

    // Create remove button
    const removeButton = document.createElement('button');
    removeButton.textContent = 'Remove';
    removeButton.classList.add('remove');
    removeButton.onclick = function() {
        li.remove();
    };

    li.appendChild(removeButton);
    document.getElementById('taskList').appendChild(li);
    taskInput.value = ''; // Clear input field
}
