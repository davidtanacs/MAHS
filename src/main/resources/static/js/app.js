function booking() {
    var name = $('#name').val();
    var lockerno = $('#lockerno').val();
    var masseur = $('#masseur').val();
    var length = $('#length').val();
    length = length[0] + length[1];
    var time = $('#time').val();
    var timelist = time.split(":");
    var hour = timelist[0];
    var minute = timelist[1];
    var confirmation = confirm("Hello " + name + "!(locker NO: " + lockerno + ")\nYou are booking a " + length.valueOf() + " minutes long massage at " + time
        + ". \nYour would get the treatment from " + masseur + ". \nAre you sure you would like to book it?");
    if (confirmation === true) {
        $.ajax({
            url:'/submitBooking/' + lockerno + '/' + name + '/' + length + '/' + hour + '/' + minute + '/' + masseur,
            type:'post',
            success: function(){
                alert("Booking successful for a " + length + " minutes long massage at " + hour + ":" + minute + " by " + masseur + " ."
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