package game;

import notecontext.NamedNote;

public interface MusicObject {

    @Override
    public boolean equals(Object other);

    public NamedNote[] getNotes();

}
