

export const baseURL = "http://localhost:8080/api";
export const baseURLAuth = "http://localhost:8080/auth";
export const userId = sessionStorage.getItem('userId');
export const userRole = sessionStorage.getItem('role');
export function getStatus(iss_status) {
    var issSt = "";
    if (iss_status == "0") {
        issSt = "New";
    } else if (iss_status == "1") {
        issSt = "Accepted";
    } else if (iss_status == "2") {
        issSt = "In progress";
    } else if (iss_status == "3") {
        issSt = "Done";
    } else if (iss_status == "5") {
        issSt = "Closed";
    }
    return issSt;
}


export function getUserHanlder(id){
    var result = "";
    if (id == 0) {
        result = "No";
    } else{
        result = "Accepted"
    }
    return result;
}


