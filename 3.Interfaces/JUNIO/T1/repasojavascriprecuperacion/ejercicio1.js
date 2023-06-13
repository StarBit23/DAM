// En el siguiente código no se ha usando ;
// Detecta y corrige los posibes errores que ha cometido el programador

const a = 1;
const b = 2;
const x = 2;

console.log(`${x}`);

function inc(num) {
  return num + 1;
}

const y = x + inc(a + b).toString();
console.log(y);

function saludo() {
    const msg = 'Bienvenido a Javascript';
  console.log(msg);
  return msg;
}

const msg = `Mi saludo: ${saludo()}`;
console.log(msg);


