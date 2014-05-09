/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js";

$(document).ready(function() 
{

$('.block').click(function()
{
var id= $(this).attr('id'); // .block ID
var data_id= $(".data").html(); // .data DIV value
var panel= $('.panel');
var panel_width=$('.panel').css('left'); // rolling panel width


if(data_id===id)
{
// Rolling Animation
panel.animate({left: parseInt(panel.css('left'),0) === 0 ? +panel.outerWidth() : 0});
}
else
{
// panel width CSS width:340px + border:1px = 341px
if(panel_width==='341px')
{
// No rolling animation
}
else
{
// Rolling Animation
panel.animate({left: parseInt(panel.css('left'),0) === 0 ? +panel.outerWidth() : 0});
}
}
// passing id value to <div class='data'$gt; </div>
$('.data').html(id);
return false;
});

// panel close link
$('.close').click(function() 
{
var panel= $('.panel');
panel.animate({left: parseInt(panel.css('left'),0) === 0 ? +panel.outerWidth() : 0});
return false;
});

});