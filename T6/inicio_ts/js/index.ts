let nombre: string;
let edad: number;
let experiencia: boolean;
let asignaturas: any[];

function parametrosOptativos(param1:string, param2: string, param3: number = 0) {
    console.log(`Los parámetros son ${param1}, ${param2}, ${param3}`);
}

parametrosOptativos("uno", "dos");