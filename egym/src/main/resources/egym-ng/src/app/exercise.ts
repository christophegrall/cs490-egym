import { Difficulty } from './difficulty.enum';
import { Type } from './type.enum';

export class Exercise {
    public id: number;
    public name: string;
    public description: string;
    public difficulty: Difficulty;
    public type: Type;
    public builtin: boolean;
}
