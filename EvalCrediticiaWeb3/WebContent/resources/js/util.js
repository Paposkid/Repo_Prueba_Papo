/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @description <p>Valida que la entrada de un componente <code>input</code>
 * sea unicamente numerico.</p>
 * @return <p><code>true</true> si cumple con los requisitos,
 * <code>false</true> en cualquier otro caso </p>
 *
 */
function numberValidator(evt, length) {
    if(evt.charCode == 0 || evt.ctrlKey || evt.altKey) {
        return true;
    }
    var regExp = new RegExp("^\\d{1," + length + "}$");
    var cadena = evt.currentTarget.value +
    String.fromCharCode(evt.charCode);
    return regExp.test(cadena);
}

function charValidator(evt, length) {
    if(evt.charCode == 0 || evt.ctrlKey || evt.altKey) {
        return true;
    }
    var regExp = new RegExp("^[a-zA-ZñÑ]{1," + length + "}$");
    var cadena = evt.currentTarget.value +
    String.fromCharCode(evt.charCode);
    return regExp.test(cadena);
}

function showIframeCambiosIntraway(usuario, cuenta) {
    Richfaces.hideModalPanel('modalPanelInventario');
    //TODO: cambiar url de Aplicar Cambios Intraway
    srciframe = 'http://192.168.15.17:8082/Interfaces/Valida_servicios/iFrame_Valida_Servicios.php?' +
    'cuenta=' + cuenta +'&usuario=' + usuario;

    document.getElementById('iframeCambiosIntraway').src = srciframe;
    Richfaces.showModalPanel('modalPanelCambiosIntraway',{
        width:'950px',
        height:'520px'
    });
}

function showIframeCableModem(direccionIP) {
    Richfaces.hideModalPanel('modalPanelInventario');
    srciframe = 'http://' + direccionIP + '/';

    document.getElementById('iframeCableModem').src = srciframe;
    Richfaces.showModalPanel('modalPanelCableModem',{
        width:'950px',
        height:'520px'
    });
}

function showIframeActivacionNGN(URL) {
    Richfaces.hideModalPanel('activarModalPanel');
    //document.getElementById('iframeActivacionNGN').document.body.innerHTML = '';
    document.getElementById('iframeActivacionNGN').src = URL;
    Richfaces.showModalPanel('activacionNGNModalPanel');
}

var ecareUrl;
var ecareIdUsuario;
var ecareUsuario;
var ecareOrigen;

function showIframeEcareFactura(url, IdUsuario, Usuario, Origen) {
    ecareUrl = url;
    ecareIdUsuario = IdUsuario;
    ecareUsuario = Usuario;
    ecareOrigen = Origen;
    Richfaces.showModalPanel('facturaModalPanel');
    var frameEcare = document.getElementById('iframeEcareFactura');
    frameEcare.src='/mascara/resources/js/viewInvoice.html';
}

function showIframe(url, IdUsuario, Usuario, Origen, modalId, idElemento) {
    ecareUrl = url;
    ecareIdUsuario = IdUsuario;
    ecareUsuario = Usuario;
    ecareOrigen = Origen;
    Richfaces.showModalPanel(modalId);
    var frameEcare = document.getElementById(idElemento);
    frameEcare.src=ecareUrl;
}

function closeNGNModalPanel() {
    setTimeout("Richfaces.hideModalPanel('activacionNGNModalPanel');", 8000);
}

function showPoup(action, form, target) {
    formId=action.form.id;
    features="height=300,width=250,status=yes,toolbar=no,menubar=no,location=no,scrollbars=yes";			
    winId=window.open('','list',features); // open an empty window

    hform=document.forms[form]; // reference to the hidden form
			  
    //This is an emulation of the action link being clicked.
    hform[form+':'+target].value=form+':'+target;

    // Copy the current country variable value
    // to the corresponding field of the hidden form.
    hform[form+":country"].value = getCountry(action.form);

    // Submit the hidden form. The output will be sent to the just opened window.
    hform.submit();
}