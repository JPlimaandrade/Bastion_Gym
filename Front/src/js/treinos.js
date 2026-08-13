/**
 * Treinos - Bastion GYM
 * Arquivo: treinos.js
 * Descrição: Funcionalidades da página de treinos
 */

/**
 * Filtra os cards de treino por categoria
 * @param {string} filter - Categoria do filtro ('all', 'superiores', 'inferiores', etc)
 * @param {HTMLElement} button - Botão que foi clicado
 */
function filterWorkouts(filter, button) {
    // Remover classe active de todos os botões
    document.querySelectorAll('.filter-btn').forEach(btn => {
        btn.classList.remove('active');
    });
    
    // Adicionar classe active ao botão clicado
    button.classList.add('active');
    
    // Filtrar os cards de treino
    const workoutCards = document.querySelectorAll('.workout-card');
    
    workoutCards.forEach(card => {
        const category = card.getAttribute('data-category') || 'all';
        
        if (filter === 'all' || category === filter) {
            card.style.display = 'block';
        } else {
            card.style.display = 'none';
        }
    });
}

/**
 * Inicializa funcionalidades da página de treinos
 */
document.addEventListener('DOMContentLoaded', function() {
    // Funcionalidades de inicialização podem ser adicionadas aqui
});
