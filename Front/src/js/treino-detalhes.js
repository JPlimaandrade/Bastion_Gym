/**
 * Detalhes do Treino - Bastion GYM
 * Arquivo: treino-detalhes.js
 * Descrição: Funcionalidades da página de execução de treino
 */

/**
 * Adiciona uma nova série ao exercício
 * @param {HTMLElement} button - Botão que foi clicado
 */
function addSeries(button) {
    const seriesContainer = button.closest('.series-container');
    const currentSeries = seriesContainer.querySelectorAll('.series-item').length;
    const newSeriesNumber = currentSeries + 1;
    
    const newSeries = document.createElement('div');
    newSeries.className = 'series-item';
    newSeries.innerHTML = `
        <div class="series-number">${newSeriesNumber}</div>
        <div class="series-input-group">
            <label>Peso (kg)</label>
            <input type="number" class="series-input" placeholder="0">
        </div>
        <div class="series-input-group">
            <label>Repetições</label>
            <input type="number" class="series-input" placeholder="0">
        </div>
        <div class="series-input-group">
            <label>Descanso</label>
            <select class="series-select">
                <option value="0">0s</option>
                <option value="30">30s</option>
                <option value="60">1min</option>
                <option value="90">1min 30s</option>
                <option value="120">2min</option>
                <option value="150">2min 30s</option>
                <option value="180">3min</option>
                <option value="210">3min 30s</option>
                <option value="240">4min</option>
                <option value="270">4min 30s</option>
                <option value="300">5min</option>
            </select>
        </div>
        <div class="series-buttons">
            <button class="add-series-btn" onclick="addSeries(this)">
                <i class="fas fa-plus"></i>
            </button>
            <button class="remove-series-btn" onclick="removeSeries(this)">
                <i class="fas fa-minus"></i>
            </button>
        </div>
    `;
    
    seriesContainer.appendChild(newSeries);
    updateSeriesButtons(seriesContainer);
    updateSeriesNumbers(seriesContainer);
}

/**
 * Remove uma série do exercício
 * @param {HTMLElement} button - Botão que foi clicado
 */
function removeSeries(button) {
    const seriesContainer = button.closest('.series-container');
    const seriesItem = button.closest('.series-item');
    const seriesItems = seriesContainer.querySelectorAll('.series-item');
    
    if (seriesItems.length > 1) {
        seriesItem.remove();
        updateSeriesButtons(seriesContainer);
        updateSeriesNumbers(seriesContainer);
    }
}

/**
 * Atualiza a visibilidade dos botões de remover série
 * @param {HTMLElement} container - Container das séries
 */
function updateSeriesButtons(container) {
    const seriesItems = container.querySelectorAll('.series-item');
    seriesItems.forEach(item => {
        const addBtn = item.querySelector('.add-series-btn');
        const removeBtn = item.querySelector('.remove-series-btn');
        
        if (seriesItems.length > 1) {
            removeBtn.style.display = 'flex';
        } else {
            removeBtn.style.display = 'none';
        }
    });
}

/**
 * Atualiza a numeração das séries
 * @param {HTMLElement} container - Container das séries
 */
function updateSeriesNumbers(container) {
    const seriesItems = container.querySelectorAll('.series-item');
    seriesItems.forEach((item, index) => {
        const numberElement = item.querySelector('.series-number');
        numberElement.textContent = index + 1;
    });
}

/**
 * Marca ou desmarca um exercício como concluído
 * @param {HTMLElement} button - Botão que foi clicado
 */
function completeExercise(button) {
    const exerciseCard = button.closest('.exercise-card');
    const seriesInputs = exerciseCard.querySelectorAll('.series-input, .series-select');
    const seriesButtons = exerciseCard.querySelectorAll('.add-series-btn, .remove-series-btn');
    
    // Verifica se o exercício já está concluído
    if (exerciseCard.classList.contains('completed')) {
        // Desmarcar como concluído
        exerciseCard.classList.remove('completed');
        exerciseCard.style.opacity = '1';
        seriesInputs.forEach(input => {
            input.disabled = false;
        });
        seriesButtons.forEach(btn => {
            btn.disabled = false;
            btn.style.opacity = '1';
            btn.style.cursor = 'pointer';
        });
        button.innerHTML = '<i class="fas fa-check"></i> Concluir';
        button.style.background = '';
    } else {
        // Marcar como concluído
        exerciseCard.classList.add('completed');
        exerciseCard.style.opacity = '0.5';
        seriesInputs.forEach(input => {
            input.disabled = true;
        });
        seriesButtons.forEach(btn => {
            btn.disabled = true;
            btn.style.opacity = '0.5';
            btn.style.cursor = 'not-allowed';
        });
        button.innerHTML = '<i class="fas fa-check-circle"></i> Concluído';
        button.style.background = 'var(--success-color)';
    }
}

/**
 * Adiciona um novo exercício ao treino
 */
function addExercise() {
    const exercisesContainer = document.querySelector('.exercises-container');
    const currentExercises = exercisesContainer.querySelectorAll('.exercise-card').length;
    const newExerciseNumber = currentExercises + 1;
    
    const newExercise = document.createElement('div');
    newExercise.className = 'exercise-card';
    newExercise.innerHTML = `
        <div class="exercise-header">
            <h3>Exercício ${newExerciseNumber}</h3>
            <button class="complete-exercise-btn" onclick="completeExercise(this)">
                <i class="fas fa-check"></i> Concluir
            </button>
        </div>
        <div class="series-container">
            <div class="series-list">
                <!-- Séries serão adicionadas aqui -->
            </div>
            <button class="add-series-btn" onclick="addSeries(this)">
                <i class="fas fa-plus"></i> Adicionar Série
            </button>
        </div>
    `;
    
    exercisesContainer.appendChild(newExercise);
}

/**
 * Finaliza o treino
 */
function finishWorkout() {
    alert('Treino finalizado com sucesso! (Demo)');
}

/**
 * Inicializa funcionalidades da página de detalhes do treino
 */
document.addEventListener('DOMContentLoaded', function() {
    // Adiciona botão de remover série escondido inicialmente
    const seriesContainers = document.querySelectorAll('.series-container');
    seriesContainers.forEach(container => {
        updateSeriesButtons(container);
    });
});
