$(function() {
      
    var start = moment();
    var end = moment();

    function cb(start, end) {
        $('#reportrange span').html( '&nbsp;&nbsp;' + start.format('YYYY-MM-DD') + ' ~ ' + end.format('YYYY-MM-DD'));
    }

    $('#reportrange').daterangepicker({
        showDropdowns: true,
        minYear: 2020,
        maxYear: 2030,
        "autoApply": true,
        autoUpdateInput: false,
        "linkedCalendars": false,
        "locale": {
            "format": "YYYY/MM/DD",
            "separator": " ~ ",
            "applyLabel": "확인",
            "cancelLabel": "취소",
            "fromLabel": "From",
            "toLabel": "To",
            "customRangeLabel": "Custom",
            "weekLabel": "W",
            "daysOfWeek": [
                "일",
                "월",
                "화",
                "수",
                "목",
                "금",
                "토"
            ],
            "monthNames": [
                "1월",
                "2월",
                "3월",
                "4월",
                "5월",
                "6월",
                "7월",
                "8월",
                "9월",
                "10월",
                "11월",
                "12월"
            ],
            "firstDay": 7
        },
        startDate: start,
        endDate: end,
    }, cb);

    cb(start, end);

});