
document.getElementById('applicationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    
    document.getElementById('nameError').textContent = '';
    document.getElementById('phoneError').textContent = '';
    document.getElementById('emailError').textContent = '';

   
    const name = document.getElementById('name').value;
    const phone = document.getElementById('phone').value;
    const email = document.getElementById('email').value;
    const phonePattern = /^[0-9]{10}$/;
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    let valid = true;

    if (!name) {
        document.getElementById('nameError').textContent = 'Please enter your name';
        valid = false;
    }
    if (!phonePattern.test(phone)) {
        document.getElementById('phoneError').textContent = 'Please enter a valid phone number (10 digits)';
        valid = false;
    }
    if (!emailPattern.test(email)) {
        document.getElementById('emailError').textContent = 'Please enter a valid email address';
        valid = false;
    }

    
    if (valid) {
        const selectedCourses = Array.from(document.querySelectorAll('.course:checked'));
        const courseDetails = selectedCourses.map(course => course.dataset.course);
        let total = selectedCourses.reduce((sum, course) => sum + parseFloat(course.value), 0);

        
        let discount = 0;
        if (selectedCourses.length === 2) {
            discount = 0.05;
        } else if (selectedCourses.length === 3) {
            discount = 0.10;
        } else if (selectedCourses.length > 3) {
            discount = 0.15;
        }
        total = total - (total * discount);

        
        total = total * 1.15;

        
        const emailBody = `
        Invoice:\n\n
        Name: ${name}\n
        Phone: ${phone}\n
        Email: ${email}\n
        Selected Courses: ${courseDetails.join(', ')}\n
        Total (including VAT and discount): R${total.toFixed(2)}
        `;

      
        const gmailLink = `https://mail.google.com/mail/?view=cm&fs=1&to=${encodeURIComponent(email)}&su=Invoice for Selected Courses&body=${encodeURIComponent(emailBody)}`;

        
        window.open(gmailLink, '_blank');
    }
});
