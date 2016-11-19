export class User {
    public username: string;
    public password: string;
    public firstname: string;
    public lastname: string;
    public email: string;

    constructor(
        username: string,
        password: string,
        firstname: string,
        lastname: string,
        email: string
    ) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
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
