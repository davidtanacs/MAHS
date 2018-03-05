function booking() {
    var name = $('#hiddenSessionName').val();
    var lockerNo = $('#hiddenSessionLockerNo').val();
    var masseur = $('#masseur').val();
    var length = $('#length').val();
    length = length[0] + length[1];
    var time = $('#time').val();
    var confirmation = confirm("Hello " + name + "!(locker NO: " + lockerNo.valueOf() + ")\nYou are booking a " + length.valueOf() + " minutes long massage at " + time
        + ". \nYour would get the treatment from " + masseur + ". \nAre you sure you would like to book it?");
    if (confirmation === true) {
        $.ajax({
            url:'/submitBooking/' + lockerNo.valueOf() + '/' + name + '/' + length + '/' + time + '/' + masseur,
            type:'post',
            success: function(){
                alert("Booking successful for a " + length + " minutes long massage at " + time + " by " + masseur + " ."
                + "\nThank you " + name + " (locker no.: " + lockerno + ")!");
            }
        });
    } else {
        $.ajax({
          success: function () {
              window.location.replace("/booking");
          }
        });
    }
}