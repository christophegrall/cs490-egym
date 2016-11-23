export interface User {
    username: string;
    password: string;
    firstname: string;
    lastname: string;
    email: string;
}

export interface UserModel {
    username: string;
    password: string;
    password2: string;
    firstname: string;
    lastname: string;
    email: string;
}

export class UserResponse {
    public statusCode: number;
    public body: string;

    constructor(
        status: number,
        body: string
    ) {
        this.statusCode = status;
        this.body = body;
    }
}
