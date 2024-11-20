// Fee Calculation Logic
document.getElementById("feeForm").addEventListener("submit", function(e) {
    e.preventDefault();

    const selectedCourses = document.querySelectorAll('input[name="course"]:checked');
    let total = 0;
    
    selectedCourses.forEach(course => {
        total += parseInt(course.value);
    });

    let discount = 0;
    if (selectedCourses.length === 2) {
        discount = 0.05;
    } else if (selectedCourses.length === 3) {
        discount = 0.10;
    } else if (selectedCourses.length > 3) {
        discount = 0.15;
    }

    const discountedTotal = total - (total * discount);
    document.getElementById("totalFees").innerText = `Total: R${discountedTotal.toFixed(2)} (Discount: ${discount * 100}%)`;
});
