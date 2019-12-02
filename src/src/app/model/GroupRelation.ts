import { Group } from './Group';

export interface GroupRelation {
    groupRelationId: number
    ufk:number
    gfk:number
    groups:Group[] 
}